package org.amisescalade.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.amisescalade.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IInputValidator inputValidator;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    
    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
         
        principal.getName();
         
        return "user/adminpage";
    }

    // show add user form :
    @GetMapping("/signup")
    public String showAddUserForm(Model model) {

        log.debug("showAddUserForm()");
        model.addAttribute("userForm", new User());

        return "user/addform";

    }
    
        // save user
    @PostMapping("/user/userSave")
    public String saveUser(@ModelAttribute("userForm") User user, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveUser()");

        User authorFind = null;


        String sublink = "addform";

        String link = validateIsEmpty(user, sublink, model);

        if (link != null) {

            return link;
        }

        User userSave = null;

        try {
            
            userSave = iUserService.registerByDefault(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "user/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "enregisté !");

        return "redirect:/user/" + Math.toIntExact(userSave.getUserId());
    }
    
    
        // show user
    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {

        log.debug("showUser() id: {}", id);

        User userFind = null;

        try {
            userFind = iUserService.getUser(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/users";
        }
        
        byte[] imageBytes = userFind.getProfile();
        
        if (imageBytes != null) {
            
            ResponseEntity<byte[]> x = ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
            
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            
            x.toString();
           
            

            model.addAttribute("profilex", x);
            model.addAttribute("profileToString", x.toString());
            model.addAttribute("profile", base64Image);
            
        }

        model.addAttribute("userFind", userFind);
        model.addAttribute("userId", id);

        return "user/show";

    }
    
    	@GetMapping("/getPhoto/{id}")
	public void getPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");
                
                        log.debug("getPhoto() id: {}", id);
                        
                        System.out.println("org.amisescalade.controller.UserController.getPhoto()");

        User userFind = null;

try {
            userFind = iUserService.getUser(Long.valueOf(id));
        } catch (Exception e) {


        }
        
        byte[] imageBytes = userFind.getProfile();
        
            System.out.println("org.amisescalade.controller.UserController.getPhoto()"+imageBytes.length);

		InputStream inputStream = new ByteArrayInputStream(imageBytes);
		IOUtils.copy(inputStream, response.getOutputStream());
                
                System.out.println("org.amisescalade.controller.UserController.getPhoto() FINI");
	}
        
        
        @GetMapping("/user/account")
        
    public String userAccount(Model model, Principal principal) {
 

        String userName = principal.getName();
 
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        
       User loginedUser = iUserService.getUserByUsername(userName);
        
        model.addAttribute("userFind", loginedUser);
 
        return "user/show";
    }
        
        
        
        
    
     // user list page
    @GetMapping("/users")
    public String showAllUsers(Model model) {

        log.debug("showAllUsers()");

        List<User> users = iUserService.getAllUsers();

        model.addAttribute("users", users);

        return "/user/list";
    }
    
    // show uploadform :
    @GetMapping("/user/{id}/upload")
    public String showUploadForm(@PathVariable("id") int id, Model model) {

        log.debug("showUploadForm() : {}", id);

        User userFind = new User();

        try {
            userFind = iUserService.getUser(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/"+id;
        }

        model.addAttribute("userFind", userFind);

        return "user/upload";

    }

    // upload profile
    @PostMapping("/userUpload")
    public String uploadProfile(@RequestParam("id") int id, @RequestParam("profile") MultipartFile file, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("uploadProfile() id: {}", id);  
        
        User userUpdate = null;

        try {
            userUpdate = iUserService.uploadProfile(file, id);
                    
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/users";
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/user/" + Math.toIntExact(userUpdate.getUserId());

    }
    
    // login
    
    @GetMapping("/login")
    public String login() {
        return "user/login";
        
        
    }
    
        // 403
    
    @GetMapping("/403")
    public String accessDenied() {
        return "user/403";
        
        
    }

    
    
    public User signUpByDefault(String firstname, String lastname, String username, String password) {

        try {
            inputValidator.validateCharacter(firstname);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            inputValidator.validateCharacter(lastname);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            inputValidator.validateCharacter(username);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        User userSave = new User();

        try {
            userSave = iUserService.registerByDefault(firstname, lastname, username, password);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return userSave;

    }

    public User displayUser(Long id) {

        User userFind = new User();

        try {
            userFind = iUserService.getUser(id);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return userFind;
    }

    public User editUser(User user) {

        try {
            inputValidator.validateCharacter(user.getFirstname());
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            inputValidator.validateCharacter(user.getLastname());
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            inputValidator.validateCharacter(user.getUsername());
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        User userEdit = new User();

        try {
            userEdit = iUserService.edit(user);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        return userEdit;
    }

    public Boolean signInUser(String username, String password) {

        Boolean loginStatus = false;

        try {
            loginStatus = iUserService.sampleLogin(username, password);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return loginStatus;

    }

    public List<User> displayAllUsers() {

        return iUserService.getAllUsers();
    }

    public List<User> displayAllUsersByUserCategory(Role userCategory) {

        return iUserService.getUsersByCategory(userCategory);
    }
    
    public String validateIsEmpty(User user, String link, Model model) {

        if (user.getFirstname().isEmpty()) {

            model.addAttribute("error", "le prénom  isEmpty");

            return "user/" + link;

        }

        if (user.getLastname().isEmpty()) {

            model.addAttribute("error", "le nom  isEmpty");

            return "user/" + link;

        }

        if (user.getUsername().isEmpty()) {

            model.addAttribute("error", "Votre identifiant  isEmpty");

            return "user/" + link;

        }

        if (user.getPassword().isEmpty()) {

            model.addAttribute("error", "votre mot de passe isEmpty");

            return "user/" + link;

        }
        return null;

    }

}

package org.amisescalade.controller;

import java.io.ByteArrayInputStream;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amisescalade.entity.User;
import org.amisescalade.services.IUserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
//@Transactional
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    // show admination page
    @GetMapping("/admin")
    public String showAdminPage() {

        log.debug("showAdminPage()");

        return "user/adminpage";
    }

    // show add user form
    @GetMapping("/signup")
    public String showAddUserForm(Model model) {

        log.debug("showAddUserForm()");
        model.addAttribute("userForm", new User());

        return "user/addform";

    }

    // save user
    @PostMapping("signup")
    public String saveUser(@ModelAttribute("userForm") User user, @RequestParam("passwordMatch") String passwordMatch, Model model) {

        log.debug("saveUser()");

        System.out.println("tests passwordMatch" + passwordMatch);

        User userSave = null;

        try {

            String link = validateAccount(user, passwordMatch, "addform", model);

            if (link != null) {

                return link;
            }

            userSave = iUserService.registerByDefault(user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getPassword());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "user/addform";
        }

        model.addAttribute("create", "Votre compte est créé ! ");
        model.addAttribute("user", userSave);

        return "redirect:/confirmation";
    }

    // show user
    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") int id, Model model, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("showUser() id: {}", id);

        User userFind = null;

        try {
            userFind = iUserService.getUser(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/users";
        }

        boolean owner = isOwner(principal.getName(), userFind.getUsername());

        model.addAttribute("userFind", userFind);
        model.addAttribute("owner", owner);

        return "user/show";

    }

    // show user photo
    @GetMapping("/getPhoto/{id}")
    public void getPhoto(HttpServletResponse response, @PathVariable("id") int id) {

        log.debug("getPhoto() id: {}", id);

        response.setContentType("image/jpeg");

        ByteArrayInputStream inputStream = null;

        try {

            inputStream = iUserService.getProfile(Long.valueOf(id));

            IOUtils.copy(inputStream, response.getOutputStream());

        } catch (Exception e) {

        }
    }

    // show user account
    @GetMapping("/user/account")
    public String userAccount(Model model, Principal principal) {

        String userName = principal.getName();

        User loginedUser = iUserService.getUserByUsername(userName);

        model.addAttribute("userFind", loginedUser);
        model.addAttribute("owner", true);

        return "user/show";
    }

    // user list page
    @GetMapping("admin/users")
    public String showAllUsers(Model model) {

        log.debug("showAllUsers()");

        List<User> users = iUserService.getAllUsers();

        model.addAttribute("users", users);

        return "/user/list";
    }

    // user list page by username
    @GetMapping("/user/search")
    public String searchUser(Model model, @RequestParam("username") String username, final RedirectAttributes redirectAttributes) {

        List<User> userList = null;

        try {
            userList = iUserService.getAllUserByUsername(username);
        } catch (Exception e) {

           redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/admin/users";
        }

        model.addAttribute("users", userList);

        return "/user/list";
    }

    // show uploadform :
    @GetMapping("/user/upload")
    public String showUploadForm(Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("showUploadForm() : {}");

        User userFind = new User();

        try {
            userFind = iUserService.getUserByUsername(principal.getName());
        } catch (Exception e) {

           redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/account";
        }

        model.addAttribute("userFind", userFind);

        return "user/upload";

    }

    // upload profile
    @PostMapping("/userUpload")
    public String uploadProfile(Principal principal, @RequestParam("profile") MultipartFile file, final RedirectAttributes redirectAttributes) {

        log.debug("uploadProfile() id: {}");

        try {
           iUserService.uploadProfile(file, principal.getName());

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/update";
        }

        redirectAttributes.addFlashAttribute("msg", "photo enregistrée ! ");

        return "redirect:/user/update";

    }

    // show update user form :
    @GetMapping("/user/update")
    public String showUpdateUserForm(Model model, Principal principal) {

        log.debug("showUpdateUserForm() : {id}");

        User userFind = new User();

        try {
            userFind = iUserService.getUserByUsername(principal.getName());
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/users";
        }

        model.addAttribute("userFind", userFind);

        return "user/updateform";

    }

    // update user
    @PostMapping("/user/userupdate")
    public String updateUser(@ModelAttribute("userFind") User user, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("updateUser() id: {}");

        try {

            String link = validateAccountDetail(user, "updateform", model);

            if (link != null) {
                return link;

            }

           iUserService.edit(user);
           
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/account";
        }

        redirectAttributes.addFlashAttribute("msg", "Modifications enregistrées ! ");

        return "redirect:/user/account";

    }

    // get update form password
    @GetMapping("/user/passform")
    public String passform(Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("passform()");

        User userFind = null;

        try {
            userFind = iUserService.getUserByUsername(principal.getName());
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/update";
        }

        model.addAttribute("userFind", userFind);

        return "/user/password";
    }

    @PostMapping("/user/passwordupdate")
    public String passwordUpdate(@ModelAttribute("userFind") User user, @RequestParam("passwordMatch") String passwordMatch, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("passform()");

        try {

            String link = validatePassword(user, passwordMatch, "password", model);

            if (link != null) {

                return link;
            }

            iUserService.updatePassword(passwordMatch, principal.getName());

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/update";
        }

        redirectAttributes.addFlashAttribute("msg", "Votre mot de passe a été modifié !");

        return "redirect:/user/update";

    }

    // delette user
    @PostMapping("/user/delete")
    public String deleteUser(Principal principal, final RedirectAttributes redirectAttributes, Model model, HttpServletRequest request) {

        log.debug("deleteUser() id: {}");

        try {
           iUserService.delete(principal.getName());
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/account";
        }

        redirectAttributes.addFlashAttribute("delete", "Membre supprimé !");

        new SecurityContextLogoutHandler().logout(request, null, null);

        return "redirect:/confirmation";

    }

    // desactivate user
    @PostMapping("/admin/user/desactivate")
    public String desactivateUser(@RequestParam("id") Long id, final RedirectAttributes redirectAttributes) {

        log.debug("desactivateUser()");

        try {
            iUserService.desactivate(id);
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            
            return "redirect:/admin/users";
            
        }

        redirectAttributes.addFlashAttribute("desactivate", "Membre suspendu !");

        return "redirect:/confirmation";

    }

    // confirmation
    @GetMapping("/confirmation")
    public String confirmation() {
        return "/common/confirmation";

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

    // controle methode 
    public String validateAccount(User user, String passwordMatch, String link, Model model) {

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

        if (!user.getPassword().equals(passwordMatch)) {

            model.addAttribute("error", "vos mots de pase ne correspond pas");

            return "user/" + link;

        }

        if (user.getEmail().isEmpty()) {

            model.addAttribute("error", "votre email isEmpty");

            return "user/" + link;

        }

        if (!isValidEmail(user.getEmail())) {

            model.addAttribute("error", "email invalide");

            return "user/" + link;

        }

        return null;

    }

    public String validateAccountDetail(User user, String link, Model model) {

        if (user.getFirstname().isEmpty()) {

            model.addAttribute("error", "le prénom  isEmpty");

            return "user/" + link;

        }

        if (user.getLastname().isEmpty()) {

            model.addAttribute("error", "le nom  isEmpty");

            return "user/" + link;

        }

        if (user.getEmail().isEmpty()) {

            model.addAttribute("error", "votre email isEmpty");

            return "user/" + link;

        }

        if (!isValidEmail(user.getEmail())) {

            model.addAttribute("error", "email invalide");

            return "user/" + link;

        }

        return null;

    }

    public String validatePassword(User user, String passwordMatch, String link, Model model) {

        System.out.println("org.amisescalade.controller.UserController.validatePassword()");

        if (user.getPassword().isEmpty()) {

            model.addAttribute("error", "votre mot de passe isEmpty");

            return "user/" + link;

        }

        if (!user.getPassword().equals(passwordMatch)) {

            model.addAttribute("error", "vos mots de pase ne correspond pas");

            return "user/" + link;

        }
        return null;

    }

    public boolean isValidEmail(String email) {
        // create the EmailValidator instance
        EmailValidator validator = EmailValidator.getInstance();

        // check for valid email addresses using isValid method
        return validator.isValid(email);

    }

    public boolean isOwner(String username, String userFind) {

        System.out.println(username);

        System.out.println(userFind);

        System.out.println(username.equals(userFind));

        if (username.equals(userFind)) {

            return true;

        }

        return false;

    }
}

package org.amisescalade.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.services.interfaces.ITopoService;
import org.amisescalade.services.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class TopoController {

    private final Logger log = LogManager.getLogger(TopoController.class);

    @Autowired
    private ITopoService iTopoService;

    @Autowired
    private IUserService iUserService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    // topo list page by id owner topo
    @GetMapping("/user/{id}/owner")
    public String showAllTopoByOwner(@PathVariable("id") int id, Model model, Principal principal) {

        log.debug("showAllTopoByUser()");

        User userFind = null;
        List<Topo> topoFind = null;

        try {

            userFind = iUserService.getUser(Long.valueOf(id));

            topoFind = iTopoService.getAllToposByOwner(userFind);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/" + id;

        }

        boolean owner = isOwner(principal.getName(), userFind.getUsername());

        model.addAttribute("topos", topoFind);
        model.addAttribute("owner", owner);
        model.addAttribute("user", userFind);

        return "topo/list";

    }

    // booking list page by owner topo
    @GetMapping("/user/bookings/topos")
    public String showAllBookingByOwnerTopo(Model model, Principal principal) {

        log.debug("showAllBookingsbyOwnerTopo()");

        Optional<User> userFind = null;
        List<Topo> topoList = null;

        try {
            userFind = iUserService.getUserByUsername(principal.getName());

            topoList = iTopoService.getAllToposByOwner(userFind.get());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "/booking/askbookinglist";

        }

        model.addAttribute("topos", topoList);
        model.addAttribute("user", userFind.get());

        return "/booking/askbookinglist";

    }

    // topo list page by login owner topo
    @GetMapping("/user/topos")
    public String showAllByOwnerTopo(Model model, Principal principal) {

        log.debug("showAllByOwnerTopo()");

        Optional<User> userFind = null;
        List<Topo> topoList = null;

        try {
            userFind = iUserService.getUserByUsername(principal.getName());

            System.out.println("org.amisescalade.controller.TopoController.showAllByOwnerTopo()" + userFind.toString());

            topoList = iTopoService.getAllToposByOwner(userFind.get());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "/topo/list";

        }

        boolean owner = isOwner(principal.getName(), userFind.get().getUsername());

        model.addAttribute("topos", topoList);
        model.addAttribute("user", userFind.get());
        model.addAttribute("owner", owner);

        return "/topo/list";

    }

    // show add topo form with user
    @GetMapping("/user/topo/add")
    public String showAddTopoForm(Model model) {

        log.debug("showAddTopoForm()");
        model.addAttribute("topoForm", new Topo());

        return "/topo/addform";

    }

    // save topo with user
    @PostMapping("/user/topoSave")
    public String saveTopo(@ModelAttribute("topoForm") Topo topo, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveTopo()");

        String sublink = "addform";

        String link = validateIsEmpty(topo, sublink, model);

        if (link != null) {

            return link;

        }

        Optional<User> ownerFind = null;
        Topo topoNew = null;

        try {
            ownerFind = iUserService.getUserByUsername(principal.getName());

            topoNew = iTopoService.register(topo.getTopoArea(), topo.getTopoTitle(), topo.getTopoDescription(), topo.getReleaseDate(), ownerFind.get());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "/topo/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "Topo enregistré ! ");

        return "redirect:/user/topo/" + Math.toIntExact(topoNew.getTopoId());

    }

    // show update topo form :
    @GetMapping("/user/topo/{id}/update")
    public String showUpdateTopoForm(@PathVariable("id") int id, Principal principal, Model model) {

        log.debug("showUpdateTopoForm() : {}", id);

        hasPermission(principal.getName(), id);

        Topo topoFind = null;

        try {
            topoFind = iTopoService.getTopo(Long.valueOf(id));

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/topo/" + id;
        }

        model.addAttribute("topoFind", topoFind);

        return "/topo/updateform";

    }

    // update topo
    @PostMapping("/user/topoUpdate")
    public String updateTopo(@ModelAttribute("topoFind") Topo topo, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("updateTopo() : {}");

        String sublink = "updateform";

        String link = validateIsEmpty(topo, sublink, model);

        if (link != null) {

            return link;

        }

        Topo topoUpdate = null;

        try {
            topoUpdate = iTopoService.edit(topo);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            return "/topo/updateform";
        }

        redirectAttributes.addFlashAttribute("msg", "Topo modifié ! ");

        return "redirect:/user/topo/" + Math.toIntExact(topoUpdate.getTopoId());
    }

    // delette topo
    @PostMapping("/user/topo/{id}/delete")
    public String deleteTopo(@PathVariable("id") int id, Principal principal, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("deleteTopo() id: {}", id);

        hasPermission(principal.getName(), id);

        try {

            iTopoService.delete(Long.valueOf(id));

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/user/topo/" + id;

        }

        redirectAttributes.addFlashAttribute("msg", "topo supprimé");

        return "redirect:/user/topos";

    }

    // show topo
    @GetMapping("/user/topo/{id}")
    public String showTopo(@PathVariable("id") Long id, Model model, Principal principal) {

        log.debug("showTopo id: {}", id);

        Topo topoFind = null;

        try {
            topoFind = iTopoService.getTopo(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
        }

        boolean owner = isOwner(principal.getName(), topoFind.getTopoOwner().getUsername());

        model.addAttribute("topoFind", topoFind);
        model.addAttribute("owner", owner);

        return "/topo/show";

    }

    // topo list page
    @GetMapping("/topos")
    public String showAllTopos(Model model, @RequestParam(name = "page", defaultValue = "0") int p, @RequestParam(name = "size", defaultValue = "5") int s) {

        log.debug("showAllTopos()");

        Page<Topo> topoPage = iTopoService.getAllTopos(p, s);

        int numberPage = topoPage.getTotalPages();
        List<Topo> topos = topoPage.getContent();
        int[] pages = new int[numberPage];

        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        model.addAttribute("topos", topos);

        System.out.println("le post marche !! topos");

        return "/topo/list";
    }

    public String validateIsEmpty(Topo topo, String link, Model model) {

        if (topo.getTopoTitle().isEmpty()) {

            model.addAttribute("error", "le titre n'est pas renseigné");

            return "topo/" + link;

        }

        if (topo.getTopoArea().isEmpty()) {

            model.addAttribute("error", "le lieu n'est pas renseigné");

            return "topo/" + link;

        }

        if (topo.getReleaseDate() == null) {

            model.addAttribute("error", "la date de paration n'est pas renseigné");

            return "topo/" + link;

        }

        return null;

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

    public String hasPermission(String username, int id) {

        User userFind = null;

        try {

            userFind = iTopoService.getTopo(Long.valueOf(id)).getTopoOwner();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception ex) {

            return "redirect:/user/topo/" + id;

        }

        return "redirect:/user/topo/" + id;

    }

}

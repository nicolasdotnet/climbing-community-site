package org.amisescalade.controller;

import java.util.List;
import java.util.logging.Level;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.services.ITopoService;
import org.amisescalade.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class TopoController {

    private final Logger log = LogManager.getLogger(TopoController.class);

    @Autowired
    private ITopoService iTopoService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IInputValidator inputValidator;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    @GetMapping("/topos")
    public String showAllTopos() {

        log.debug("showAllTopos()");

        return "topo/list";
    }

    @GetMapping("/user/topos")
    public String showAllTopoByUser(Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAllTopoByUser()");

        User owner = null;
        List<Topo> topoFind = null;

        try {

            owner = iUserService.getUser(2L);
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
        }

        try {
            topoFind = iTopoService.getAllToposByOwner(owner);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());

            return "redirect:/user/topos";
        }

        System.out.println("le post marche !! comment");

        model.addAttribute("topos", topoFind);
        model.addAttribute("user", owner);

        return "topo/list";

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
    public String saveSectorSpot(@ModelAttribute("topoForm") Topo topo, final RedirectAttributes redirectAttributes, Model model) {

        System.out.println("le post marche !! topoForm : " + topo.getTopoTitle());

        User ownerFind = null;

        try {
            ownerFind = iUserService.getUser(2L);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        String sublink = "addform";

        String link = validateIsEmpty(topo, sublink, model);

        if (link != null) {

            return link;

        }

        Topo topoNew = null;
        try {
            topoNew = iTopoService.register(topo.getTopoArea(), topo.getTopoTitle(), topo.getTopoDescription(), ownerFind);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/user/topo/" + Math.toIntExact(topoNew.getTopoId());

    }

    // show update topo form :
    @GetMapping("/user/topo/{id}/update")
    public String showUpdateTopoForm(@PathVariable("id") int id, Model model) {

        log.debug("showUpdateTopoForm() : {}", id);

        Topo topoFind = null;

        try {
            topoFind = iTopoService.getTopo(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        model.addAttribute("topoFind", topoFind);

        return "/topo/updateform";

    }

    // update topo
    @PostMapping("/user/topoUpdate")
    public String UpdateTopo(@ModelAttribute("topoFind") Topo topo, final RedirectAttributes redirectAttributes, Model model) {

        String sublink = "updateform";

        String link = validateIsEmpty(topo, sublink, model);

        if (link != null) {

            return link;

        }

        Topo topoUpdate = null;

        try {
            topoUpdate = iTopoService.edit(topo);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/user/topo/" + Math.toIntExact(topoUpdate.getTopoId());
    }

    //delette topo
    @PostMapping("/user/topo/{id}/delete")
    public String deleteTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteTopo() id: {}", id);

        System.out.println("deleteTopo() id: {}" + id);

        Topo topoFind = null;

        try {

            topoFind = iTopoService.getTopo(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        Long userId = topoFind.getTopotopoOwner().getUserId();

        iTopoService.delete(Long.valueOf(id));

        redirectAttributes.addFlashAttribute("msg", "delete");

//        return "redirect:/user/"+ Math.toIntExact(userId);
        return "/topo/user/" + Math.toIntExact(userId);

    }

    // show topo
    @GetMapping("/user/topo/{id}")
    public String showTopo(@PathVariable("id") Long id, Model model) {

        Topo topoFind = null;

        try {
            topoFind = iTopoService.getTopo(Long.valueOf(id));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TopoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        model.addAttribute("topoFind", topoFind);

        return "/topo/show";

    }

    public String validateIsEmpty(Topo topo, String link, Model model) {

        if (topo.getTopoTitle().isEmpty()) {

            model.addAttribute("error", "le titre  isEmpty");

            return "topo/" + link;

        }

        if (topo.getTopoArea().isEmpty()) {

            model.addAttribute("error", "le lieu  isEmpty");

            return "topo/" + link;

        }

        return null;

    }

    public List<Topo> displayTopoByTitle(String topoTitle) {

        List<Topo> topoComponentList = null;

        try {
            topoComponentList = iTopoService.getTopoByTitle(topoTitle);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return topoComponentList;
    }

}

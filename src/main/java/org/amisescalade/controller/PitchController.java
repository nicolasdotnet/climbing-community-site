package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Component;
import org.amisescalade.entity.Pitch;
import org.amisescalade.services.interfaces.IComponentService;
import org.amisescalade.services.interfaces.IPitchService;
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
public class PitchController {

    private final Logger log = LogManager.getLogger(PitchController.class);

    @Autowired
    private IComponentService iComponentService;

    @Autowired
    private IPitchService iPitchService;

    // show add pitch form with component
    @GetMapping("/user/component/{id}/pitch/add")
    public String showAddPitchForm(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAddPitchForm()");

        Component componentFind = null;

        try {
            componentFind = iComponentService.getComponent(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        model.addAttribute("pitchForm", new Pitch());
        model.addAttribute("component", componentFind);

        return "/pitch/addform";

    }

    // save pitch with component
    @PostMapping("/user/pitchSave/{id}")
    public String savePitchComponent(@ModelAttribute("pitchForm") Pitch pitch, @PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("savePitchComponent()");

        String sublink = "addform";

        String link = validateIsEmpty(pitch, sublink, model);

        Component componentFind = null;

        try {
            componentFind = iComponentService.getComponent(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/user/component/" + id + "/pitch/add";

        }

        if (link != null) {

            model.addAttribute("component", componentFind);

            return link;

        }

        Pitch pitchNew = null;
        try {
            pitchNew = iPitchService.register(pitch.getPitchCode(), pitch.getPitchHeight(), pitch.getPitchRate(), Long.valueOf(id), principal.getName());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("component", componentFind);
            model.addAttribute("pitchForm", pitch);

            return "/pitch/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "Longueur enregistrée !");

        return "redirect:/pitch/" + Math.toIntExact(pitchNew.getPitchId());

    }

    // show update pitch form :
    @GetMapping("/user/pitch/{id}/update")
    public String showUpdatePitchForm(@PathVariable("id") int id, Principal principal, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showUpdatePitchForm() : {}", id);

        hasPermission(principal.getName(), id);

        Pitch pitchFind = null;

        try {
            pitchFind = iPitchService.getPitch(Long.valueOf(id));

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/pitch/" + id;
        }

        model.addAttribute("pitchFind", pitchFind);
        model.addAttribute("component", pitchFind.getComponent());

        return "/pitch/updateform";

    }

    // update pitch
    @PostMapping("/user/pitch/update")
    public String UpdatePitch(@ModelAttribute("pitchFind") Pitch pitch, final RedirectAttributes redirectAttributes, Model model) {

        String sublink = "updateform";

        String link = validateIsEmpty(pitch, sublink, model);

        if (link != null) {

            return link;

        }

        Pitch pitchUpdate = null;

        try {
            pitchUpdate = iPitchService.edit(pitch);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/pitch/" + Math.toIntExact(pitch.getPitchId()) + "/update";
        }

        redirectAttributes.addFlashAttribute("msg", "Longeur modifiée !");

        return "redirect:/pitch/" + Math.toIntExact(pitchUpdate.getPitchId());
    }

    // show pitch
    @GetMapping("/pitch/{id}")
    public String showPitch(@PathVariable("id") Long id, Principal principal, Model model) {

        log.debug("showPitch() id: {}", id);

        Pitch pitchFind = null;

        try {

            pitchFind = iPitchService.getPitch(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "common/infos";
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), pitchFind.getPitchAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("pitchFind", pitchFind);

        return "/pitch/show";

    }

    // pitch list page by component
    @GetMapping("/component/{id}/pitchs")
    public String showAllPitchs(@PathVariable("id") int id, Model model, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("showAllPitchs()");

        Component componentFind = null;
        List<Pitch> pitchList = null;

        try {
            componentFind = iComponentService.getComponent(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        try {
            pitchList = iPitchService.getAllPitchsByComponent(componentFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/component/" + id;
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), componentFind.getComponentAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("pitchs", pitchList);
        model.addAttribute("component", componentFind);

        return "/pitch/list";

    }

    //delette pitch
    @PostMapping("/user/pitch/{id}/delete")
    public String deletePitch(@PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("deletePitch() id: {}", id);

        hasPermission(principal.getName(), id);

        Pitch pitchFind = null;

        try {

            pitchFind = iPitchService.getPitch(Long.valueOf(id));

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/pitch/" + id;
        }

        Long componentId = pitchFind.getComponent().getComponentId();

        try {
            iPitchService.delete(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/pitch/" + id;
        }

        redirectAttributes.addFlashAttribute("msg", "Longeur supprimée !");

        return "redirect:/component/" + Math.toIntExact(componentId) + "/pitchs";

    }

    public String validateIsEmpty(Pitch pitch, String link, Model model) {

        if (pitch.getPitchCode().isEmpty()) {

            model.addAttribute("error", "Le code n'est pas renseigné");

            return "pitch/" + link;

        } else {

            if (!isNumber(pitch.getPitchCode())) {

                model.addAttribute("error", "Que des chiffres 0-9 pour le numéro de longueur !");

                return "pitch/" + link;
            }

        }

        if (pitch.getPitchRate().isEmpty()) {

            model.addAttribute("error", "La cotation n'est pas renseigné");

            return "pitch/" + link;

        }

        if (pitch.getPitchHeight().isEmpty()) {

            model.addAttribute("error", "La hauteur n'est pas renseignée");

            return "pitch/" + link;

        } else {

            if (!isNumber(pitch.getPitchHeight())) {

                model.addAttribute("error", "Que des chiffres 0-9 pour la hauteur !");

                return "pitch/" + link;
            }

        }
        return null;

    }

    public boolean isOwner(String username, String userFind) {

        if (username.equals(userFind)) {

            return true;

        }

        return false;

    }

    public String hasPermission(String username, int id) {

        User userFind = null;

        try {

            userFind = iPitchService.getPitch(Long.valueOf(id)).getPitchAuthor();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception e) {

            return "redirect:/pitch/" + id;

        }

        return "redirect:/pitch/" + id;

    }

    public boolean isNumber(String height) {

        String number = "[0-9]+";

        if (height.matches(number)) {

            return true;

        }
        return false;

    }

}

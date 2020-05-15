package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.amisescalade.services.interfaces.ICountry;
import org.amisescalade.services.interfaces.ILocation;
import org.amisescalade.services.interfaces.ISpotService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class SpotController {

    private final Logger log = LogManager.getLogger(SpotController.class);

    @Autowired
    private ISpotService iSpotService;

    @Autowired
    private ILocation iLocation;

    @Autowired
    private ICountry iCountry;

    // show add spot form :
    @GetMapping("/user/spot/add")
    public String showAddSpotForm(Model model) {

        log.debug("showAddSpotForm()");
        model.addAttribute("spotForm", new Spot());
        model.addAttribute("locations", iLocation.getAllLocation());
        model.addAttribute("countrys", iCountry.getAllCountry());

        return "spot/addform";

    }

    // save spot
    @PostMapping("/user/spotSave")
    public String saveSpot(@ModelAttribute("spotForm") Spot spot, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveSpot()");

        String sublink = "addform";

        String link = validateIsEmpty(spot, sublink, model);

        if (link != null) {

            model.addAttribute("locations", iLocation.getAllLocation());
            model.addAttribute("countrys", iCountry.getAllCountry());

            return link;

        }

        Spot spotSave = null;

        try {
            spotSave = iSpotService.register(spot.getSpotName(), spot.getSpotRate(), spot.getSpotDescription(), spot.getSpotAccessPath(), spot.getLocation(),
                    spot.getCountry(), principal.getName());
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("spotForm", spot);
            model.addAttribute("locations", iLocation.getAllLocation());
            model.addAttribute("countrys", iCountry.getAllCountry());

            return "spot/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "Site enregisté !");

        return "redirect:/spot/" + Math.toIntExact(spotSave.getSpotId());
    }

    // show update spot form :
    @GetMapping("/user/spot/{id}/update")
    public String showUpdateSpotForm(@PathVariable("id") int id, Principal principal, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showUpdateSpotForm() : {}", id);

        hasPermission(principal.getName(), id);

        Spot spotFind = new Spot();

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spot/" + id;
        }

        model.addAttribute("spotFind", spotFind);
        model.addAttribute("locations", iLocation.getAllLocation());
        model.addAttribute("countrys", iCountry.getAllCountry());

        return "spot/updateform";

    }

    // update spot
    @PostMapping("/user/spotUpdate")
    public String UpdateSpot(@ModelAttribute("spotFind") Spot spot, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("updateSpot() id: {}", spot.getSpotId());

        String sublink = "updateform";

        String link = validateIsEmpty(spot, sublink, model);

        if (link != null) {

            model.addAttribute("locations", iLocation.getAllLocation());
            model.addAttribute("countrys", iCountry.getAllCountry());
            
            return link;

        }

        Spot spotUpdate = null;

        try {
            spotUpdate = iSpotService.edit(spot);
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/spot/" + Math.toIntExact(spot.getSpotId()) + "/update";
        }

        redirectAttributes.addFlashAttribute("msg", "Site modifié !");

        return "redirect:/spot/" + Math.toIntExact(spotUpdate.getSpotId());

    }

    // modify spot status
    @PostMapping("/user/spotstatus/{id}")
    public String modifySpotStatus(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        log.debug("updateSpot() id: {}", id);

        Spot spotUpdate = null;

        try {
            spotUpdate = iSpotService.modifyStatus(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spot/" + id;
        }

        return "redirect:/spot/" + Math.toIntExact(spotUpdate.getSpotId());
    }

    // show spot
    @GetMapping("/spot/{id}")
    public String showSpot(@PathVariable("id") Long id, Principal principal, Model model) {

        log.debug("showSpot() id: {}", id);

        Spot spotFind = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/spots";
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), spotFind.getSpotAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("spotFind", spotFind);

        return "spot/show";

    }

    // spot list page
    @GetMapping("/spots")
    public String showAllSpots(Model model, @RequestParam(name = "page", defaultValue = "0") int p, @RequestParam(name = "size", defaultValue = "5") int s) {

        log.debug("showAllSpots()");

        Page<Spot> spotPage = iSpotService.getAllSpots(p, s);

        int numberPage = spotPage.getTotalPages();
        List<Spot> spots = spotPage.getContent();
        int[] pages = new int[numberPage];

        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        model.addAttribute("spots", spots);

        return "/spot/list";
    }

    // spot list page by login author spot
    @GetMapping("/user/spots")
    public String showAllByAuthorSpot(Model model, Principal principal) {

        log.debug("showAllByAuthorSpot()");

        User spotAuthor = null;
        List<Spot> spotList = null;

        try {

            spotList = iSpotService.getAllSpotsByAuthor(principal.getName());

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "/spot/list";

        }

        if (spotList == null) {

            model.addAttribute("msg", "L'auteur" + principal.getName() + "n'a pas de spot.");
            return "/spot/list";
        }

        model.addAttribute("spots", spotList);
        model.addAttribute("user", spotAuthor);
        model.addAttribute("owner", true);

        return "/spot/list";

    }

    // delette spot
    @PostMapping("/user/spot/{id}/delete")
    public String deleteSpot(@PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSpot() id: {}", id);

        hasPermission(principal.getName(), id);

        try {
            iSpotService.delete(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        redirectAttributes.addFlashAttribute("msg", "Site supprimé !");

        return "redirect:/spots";

    }

    // multisearch spot
    @GetMapping("/spot/multisearch")
    public String multisearch(Model model) {

        log.debug("multisearch()");

        return "spot/multisearch";
    }

    @GetMapping("/spot/findSpots")
    public String findSpots(
            @RequestParam("spotName") String spotName,
            @RequestParam("spotRate") String spotRate,
            @RequestParam("location") String location,
            @RequestParam("sectorCount") String sectorCount,
            Model model) {

        log.debug("findSpots()");

        List<Spot> spotsFind = iSpotService.getAllSpotsByMc(spotName, spotRate, location, sectorCount);

        model.addAttribute("spots", spotsFind);

        return "spot/list";

    }

    public String validateIsEmpty(Spot spot, String link, Model model) {

        if (spot.getSpotName().isEmpty()) {

            model.addAttribute("error", "Le nom du site n'est pas renseigné");

            return "spot/" + link;

        }

        if (spot.getSpotRate().isEmpty()) {

            model.addAttribute("error", "La cotation n'est pas renseignée");

            return "spot/" + link;

        }

        if (spot.getLocation().equalsIgnoreCase("default")) {

            model.addAttribute("error", "Le lieu n'est pas renseigné");

            return "spot/" + link;

        }

        if (spot.getCountry().equalsIgnoreCase("default")) {

            model.addAttribute("error", "Le pays n'est pas renseigné");

            return "spot/" + link;

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

            userFind = iSpotService.getSpot(Long.valueOf(id)).getSpotAuthor();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception ex) {

            return "redirect:/spot/" + id;

        }

        return "redirect:/spot/" + id;

    }
}

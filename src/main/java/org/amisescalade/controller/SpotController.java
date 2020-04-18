package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;

import org.amisescalade.services.ISpotService;
import org.amisescalade.services.IUserService;
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
    private IUserService iUserService;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    // show add spot form :
    @GetMapping("/spot/add")
    public String showAddSpotForm(Model model) {

        log.debug("showAddSpotForm()");
        model.addAttribute("spotForm", new Spot());

        return "spot/addform";

    }

    // save spot
    @PostMapping("/spotSave")
    public String saveSpot(@ModelAttribute("spotForm") Spot spot, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveSpot()");

        User authorFind = null;

        try {
            authorFind = iUserService.getUser(Long.valueOf(2L));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        String sublink = "addform";

        String link = validateIsEmpty(spot, sublink, model);

        if (link != null) {

            return link;

        }

        Spot spotSave = null;

        try {
            spotSave = iSpotService.register(spot.getSpotName(), spot.getSpotRate(), spot.getSpotDescription(), spot.getSpotAccessPath(), spot.getDepartement(),
                    spot.getCountry(), spot.getSectorCount(), spot.getSectorDescription(), spot.getRouteCount(), spot.getRouteDescription(), authorFind);
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            model.addAttribute("spotFind", spot);

            return "spot/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "enregisté !");

        return "redirect:/spot/" + Math.toIntExact(spotSave.getSpotId());
    }

    // show update spot form :
    @GetMapping("/spot/{id}/update")
    public String showUpdateSpotForm(@PathVariable("id") int id, Model model) {

        log.debug("showUpdateSpotForm() : {}", id);

        Spot spotFind = new Spot();

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/spots";
        }

        model.addAttribute("spotFind", spotFind);

        return "spot/updateform";

    }

    // update spot
    @PostMapping("/spotUpdate")
    public String UpdateSpot(@ModelAttribute("spotFind") Spot spot, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("updateSpot() id: {}", spot.getSpotId());

        String sublink = "updateform";

        String link = validateIsEmpty(spot, sublink, model);

        if (link != null) {

            return link;

        }

        Spot spotUpdate = null;

        try {
            spotUpdate = iSpotService.edit(spot);
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spots";
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/spot/" + Math.toIntExact(spotUpdate.getSpotId());

    }

    // show spot
    @GetMapping("/spot/{id}")
    public String showSpot(@PathVariable("id") Long id, Model model) {

        log.debug("showSpot() id: {}", id);

        Spot spotFind = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/spots";
        }

        model.addAttribute("spotFind", spotFind);
        model.addAttribute("spotId", id);

        System.out.println("showSpot() id: {}" + spotFind.getSpotName());

        return "spot/show";

    }

    // spot list page by name
    @GetMapping("/spot/search")
    public String searchSpot(Model model, @RequestParam("spotName") String spotName) {

        List<Spot> spotList = null;

        try {
            spotList = iSpotService.getAllSpotsByName(spotName);
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/spots";
        }

        System.out.println("le post marche !! searchSpotByMc");

        model.addAttribute("spots", spotList);

        return "/spot/list";
    }

    // spot list page
    @GetMapping("/spots")
    public String showAllSpots(Model model,@RequestParam(name= "page", defaultValue="0")int p, @RequestParam(name= "size", defaultValue="5")int s) {

        log.debug("showAllSpots()");

        Page<Spot> spotPage = iSpotService.getAllSpots(p, s);
        
        int numberPage = spotPage.getTotalPages();
        List<Spot> spots = spotPage.getContent(); 
        int [] pages = new int[numberPage];
        
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);
        model.addAttribute("pageCourante",p);
        model.addAttribute("spots", spots);
        
                System.out.println("le post marche !! spots");

        return "/spot/list";
    }

    //delette spot
    @PostMapping("/spot/{id}/delete")
    public String deleteSpot(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSpot() id: {}", id);

        System.out.println("deleteSpot() id: {}" + id);

        iSpotService.delete(Long.valueOf(id));

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/spots";

    }

    // multisearch spot
    @GetMapping("/multisearch")
    public String multisearch(Model model) {

        log.debug("multisearch()");

        return "spot/multisearch";
    }

    @GetMapping("/findSpots")
    public String findSpots(@RequestParam("spotRate") String spotRate, @RequestParam("departement") String departement, @RequestParam("sectorCount") String sectorCount, Model model) {

        log.debug("findSpots()");

        List<Spot> spotsFind = iSpotService.getAllSpotsByNameRateDepartement(spotRate, departement, sectorCount);

        model.addAttribute("spots", spotsFind);

        return "spot/list";

    }

    public String validateIsEmpty(Spot spot, String link, Model model) {

        if (spot.getSpotName().isEmpty()) {

            model.addAttribute("error", "name  isEmpty");

            return "spot/" + link;

        }

        if (spot.getSpotRate().isEmpty()) {

            model.addAttribute("error", "rate  isEmpty");

            return "spot/" + link;

        }

        if (spot.getDepartement().isEmpty()) {

            model.addAttribute("error", "dep  isEmpty");

            return "spot/" + link;

        }

        if (spot.getCountry().isEmpty()) {

            model.addAttribute("error", "country isEmpty");

            return "spot/" + link;

        }
        return null;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.web;

import java.util.List;
import java.util.logging.Level;
import org.amisescalade.controller.ISectorController;
import org.amisescalade.controller.ISpotCommentController;
import org.amisescalade.controller.ISpotController;
import org.amisescalade.controller.ITopoCommentController;
import org.amisescalade.controller.IUserController;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nicolasdotnet
 */
@Controller
public class ClimbingCommunitySiteController {

    @Autowired
    private IUserController iUserController;

    @Autowired
    private ISpotController iSpotController;

    @Autowired
    private ISectorController iSectorController;

    @Autowired
    private ISpotCommentController iSpotCommentController;
    
    @Autowired
    private ITopoCommentController iTopoCommentController;

    private final Logger log = LogManager.getLogger(ClimbingCommunitySiteController.class);


    // GESTION DES SITES/SPOTS
    // spot list page
    @GetMapping("/spots")
    public String showAllSpots(Model model) {

        log.debug("showAllSpots()");

        List<Spot> spots = iSpotController.displayAllSpots();

        System.out.println("le post marche !! spots");

        model.addAttribute("spots", spots);

        return "spotlist";
    }

    // spot list page by name
    @GetMapping("/spot/search")
    public String searchSpot(Model model, @RequestParam("spotName") String spotName) {

        List<Spot> spots = iSpotController.displaySpotByName(spotName);

        System.out.println("le post marche !! searchSpotByMc");

        model.addAttribute("spots", spots);

        return "spotlist";
    }

    // show add spot form :
    @GetMapping("/spot/add")
    public String showAddSpotForm(Model model) {

        log.debug("showAddSpotForm()");
        model.addAttribute("spotForm", new Spot());

        return "spotaddform";

    }

    // save spot
    @PostMapping("/spots")
    public String saveSpot(@ModelAttribute("spotForm") Spot spot, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotForm : " + spot.getSpotName());

        Spot spotNew = iSpotController.addSpot(spot.getSpotName(), spot.getSpotRate(), spot.getSpotDescription(), spot.getSpotAccessPath(), spot.getDepartement(), spot.getCountry());

        System.out.println("spotForm : id" + spotNew.getSpotId());
        System.out.println("spotForm : id" + Math.toIntExact(spotNew.getSpotId()));

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/spot/" + Math.toIntExact(spotNew.getSpotId());

//        return "spots";
    }

    // show spot
    @GetMapping("/spot/{id}")
    public String showSpot(@PathVariable("id") Long id, Model model) {

        log.debug("showSpot() id: {}", id);

        System.out.println("showSpot() id: {}" + id);

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

        model.addAttribute("spotFind", spotFind);

        System.out.println("showSpot() id: {}" + spotFind.getSpotName());

        return "spotshow";

    }

    //delette spot
    @PostMapping("/spot/{id}/delete")
    public String deleteSpot(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSpot() id: {}", id);

        System.out.println("deleteSpot() id: {}" + id);

        iSpotController.removeSpot(Long.valueOf(id));

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/spots";

    }

    // show update spot form :
    @GetMapping("/spot/{id}/update")
    public String showUpdateSpotForm(@PathVariable("id") int id, Model model) {

        log.debug("showUpdateSpotForm() : {}", id);

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

        model.addAttribute("spotFind", spotFind);

        return "spotupdateform";

    }

    // update spot
    @PostMapping("/spot/update")
    public String UpdateSpot(@ModelAttribute("spotFind") Spot spot, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotFind : " + spot.getSpotName());

//        Spot spotNew = iSpotController.addSpot(spot.getSpotName(), spot.getSpotRate(), spot.getSpotDescription(), spot.getSpotAccessPath(), spot.getDepartement(), spot.getCountry());
        Spot spotUpdate = iSpotController.editSpot(spot);

        System.out.println("spotUpdate : id" + spotUpdate.getSpotId());
        System.out.println("spotUpdate : id" + Math.toIntExact(spotUpdate.getSpotId()));

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/spot/" + Math.toIntExact(spotUpdate.getSpotId());

//        return "spots";
    }

    // multisearch spot
    @GetMapping("/multisearch")
    public String multisearch(Model model) {

        log.debug("multisearch()");

        return "multisearch";
    }

    @GetMapping("/findSpots")
    public String findSpots(@RequestParam("spotName") String spotName, @RequestParam("spotRate") String spotRate, @RequestParam("departement") String departement, Model model) {

        log.debug("findSpots()");

        List<Spot> spotsFind = iSpotController.searchSpots(spotName, spotRate, departement);

        model.addAttribute("spots", spotsFind);

        return "spotlist";

    }

    // SECTORS
    // sector list page with spot
    @GetMapping("/sectors/{id}")
    public String showAllsectors(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAllsectors()");

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

        try {
            List<Sector> sectors = iSectorController.displayAllSectorsBySpot(spotFind);

            System.out.println("le post marche !! sector");

            model.addAttribute("sectors", sectors);
            model.addAttribute("spotId", id);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ClimbingCommunitySiteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "sectorlist";

    }

    // show add sector form with spot
    @GetMapping("/sectors/{id}/add")
    public String showAddSectorForm(@PathVariable("id") int id, Model model) {

        log.debug("showAddSectorForm()");
        model.addAttribute("sectorForm", new Sector());
        model.addAttribute("spotId", id);

        return "sectorform";

    }

    // save sector
    @PostMapping("/sectorSave/{id}")
    public String saveOrUpdateSector(@ModelAttribute("sectorForm") Sector sector, @PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotForm : " + sector.getSectorName());

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

        Sector sectorNew = iSectorController.addSectorBySpot(sector.getSectorName(), sector.getSectorRate(), sector.getSectorDescription(), sector.getSectorAccessPath(), spotFind);

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/sector/" + Math.toIntExact(sectorNew.getSectorId());

    }

    // show sector
    @GetMapping("/sector/{id}")
    public String showSector(@PathVariable("id") Long id, Model model) {

        log.debug("showSector() id: {}", id);

        System.out.println("showSector() id: {}" + id);

        Sector sectorFind = iSectorController.displaySector(Long.valueOf(id));

        model.addAttribute("sectorFind", sectorFind);

        System.out.println("sectorSpot() id: {}" + sectorFind.getSectorName());

        return "sectorshow";

    }

    //delette sector
    @PostMapping("/sector/{id}/delete")
    public String deleteSector(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSector() id: {}", id);

        System.out.println("deleteSector() id: {}" + id);

        Sector sectorFind = iSectorController.displaySector(Long.valueOf(id));

        //TODO methode remove sector
        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/sector/" + sectorFind.getSpot().getSpotId();

    }

    // GESTION DES Commentaire/SPOTS
    // comment list page by spot
    @GetMapping("/spot/comments/{id}")
    public String showAllSpotComments(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAllComments()");

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

        try {

            List<SpotComment> comments = iSpotCommentController.displayAllSpotCommentBySpot(spotFind);

            System.out.println("le post marche !! comment");

            model.addAttribute("comments", comments);
            model.addAttribute("spotId", id);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ClimbingCommunitySiteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "commentlist";

    }

    // show add spotcomment form :
    @GetMapping("/spot/comments/{id}/add")
    public String showAddSpotCommentForm(@PathVariable("id") int id, Model model) {

        log.debug("showAddSpotCommentForm()");
        model.addAttribute("spotCommentForm", new SpotComment());
        model.addAttribute("spotId", id);

        return "spotcommentaddform";

    }

    // save spot comment
    @PostMapping("/spotcommentsave/{id}")
    public String saveSpotComment(@ModelAttribute("spotCommentForm") SpotComment SpotComment, @PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotCommentForm : ");

        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));

//        Sector sectorNew = iSectorController.addSectorBySpot(sector.getSectorName(), sector.getSectorRate(), sector.getSectorDescription(), sector.getSectorAccessPath(), spotFind);
        SpotComment SpotCommentFind = iSpotCommentController.addSpotComment(SpotComment.getCommentBody(), SpotComment.getCommentAuthor(), spotFind);

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/comment/" + Math.toIntExact(SpotCommentFind.getCommentId());

    }

    // show comment
    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable("id") Long id, Model model) {

        log.debug("showComment() id: {}", id);

        System.out.println("showComment() id: {}" + id);

//        Sector sectorFind = iSectorController.displaySector(Long.valueOf(id));
        SpotComment commentFind = iSpotCommentController.displaySpotComment(Long.valueOf(id));

        model.addAttribute("commentFind", commentFind);

        System.out.println("commentSpot() id: {}" + commentFind.getCommentId());

        return "commentshow";

    }
    
        // GESTION DES Topos
    // topos list page
    
        @GetMapping("/topos")
    public String showAllTopos(Model model) {

        log.debug("showAllTopos()");
        
        System.out.println("le post marche !! spots");

        return "topolist";
    }
}

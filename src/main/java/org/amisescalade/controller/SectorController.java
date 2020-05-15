package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.amisescalade.services.interfaces.ISectorService;
import org.amisescalade.services.interfaces.ISpotService;
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
public class SectorController {

    private final Logger log = LogManager.getLogger(SectorController.class);

    @Autowired
    private ISectorService iSectorService;

    @Autowired
    private ISpotService iSpotService;

    // show add sector form with spot
    @GetMapping("/user/spot/{id}/sector/add")
    public String showAddSectorForm(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAddSectorForm()");

        Spot spotFind = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spot/" + id;
        }

        model.addAttribute("sectorForm", new Sector());
        model.addAttribute("spot", spotFind);

        return "/sector/addform";

    }

    // save sector with spot
    @PostMapping("/user/sectorSave/{id}")
    public String saveSectorSpot(@ModelAttribute("sectorForm") Sector sector, @PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes, Model model) {

        log.debug("saveSectorSpot()");

        String sublink = "addform";

        Spot spotFind = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/user/spot/" + id + "/sector/add";

        }

        String link = validateIsEmpty(sector, sublink, model);

        if (link != null) {

            model.addAttribute("spot", spotFind);

            return link;

        }

        Sector sectorNew = null;
        try {
            sectorNew = iSectorService.registerBySpot(sector.getSectorName(), sector.getSectorRate(), sector.getSectorDescription(), sector.getSectorAccessPath(), Long.valueOf(id), principal.getName());
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("spot", spotFind);
            model.addAttribute("sectorForm", sector);
            
            return "/sector/addform";
        }

        redirectAttributes.addFlashAttribute("msg", "Secteur enregistré !");

        return "redirect:/sector/" + Math.toIntExact(sectorNew.getSectorId());

    }

    // show update sector form :
    @GetMapping("/user/sector/{id}/update")
    public String showUpdateSectorForm(@PathVariable("id") int id, Principal principal, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showUpdateSectorForm() : {}", id);

        hasPermission(principal.getName(), id);

        Sector sectorFind = null;

        try {
            sectorFind = iSectorService.getSector(Long.valueOf(id));

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/sector/" + id;
        }

        model.addAttribute("sectorFind", sectorFind);
        model.addAttribute("spot", sectorFind.getSpot());

        return "/sector/updateform";

    }

    // update sector
    @PostMapping("/user/sector/update")
    public String UpdateSpot(@ModelAttribute("sectorFind") Sector sector, final RedirectAttributes redirectAttributes, Model model) {

        String sublink = "updateform";

        String link = validateIsEmpty(sector, sublink, model);

        if (link != null) {

            return link;

        }

        Sector sectorUpdate = null;

        try {
            sectorUpdate = iSectorService.edit(sector);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/sector/" + Math.toIntExact(sector.getSectorId()) + "/update";
        }

        redirectAttributes.addFlashAttribute("msg", "Secteur modifié !");

        return "redirect:/sector/" + Math.toIntExact(sectorUpdate.getSectorId());
    }

    // show sector
    @GetMapping("/sector/{id}")
    public String showSector(@PathVariable("id") Long id, Principal principal, Model model) {

        log.debug("showSector() id: {}", id);

        Sector sectorFind = null;

        try {

            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "common/infos";
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), sectorFind.getSectorAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("sectorFind", sectorFind);

        return "/sector/show";

    }

    // sector list page by spot
    @GetMapping("/spot/{id}/sectors")
    public String showAllsectors(@PathVariable("id") int id, Model model, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("showAllsectors()");

        Spot spotFind = null;
        List<Sector> sectorList = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spot/" + id;
        }

        try {
            sectorList = iSectorService.getAllSectorsBySpot(spotFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/spot/" + id;
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), spotFind.getSpotAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        model.addAttribute("sectors", sectorList);
        model.addAttribute("spot", spotFind);

        return "/sector/list";

    }

    //delette sector
    @PostMapping("/user/sector/{id}/delete")
    public String deleteSector(@PathVariable("id") int id, Principal principal, final RedirectAttributes redirectAttributes) {

        log.debug("deleteSector() id: {}", id);

        hasPermission(principal.getName(), id);

        Sector sectorFind = null;

        try {

            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/sector/" + id;
        }

        Long spotId = sectorFind.getSpot().getSpotId();

        try {
            iSectorService.delete(Long.valueOf(id));
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/sector/" + id;
        }

        redirectAttributes.addFlashAttribute("msg", "Secteur supprimé !");

        return "redirect:/spot/" + Math.toIntExact(spotId) + "/sectors";

    }

    public String validateIsEmpty(Sector sector, String link, Model model) {

        if (sector.getSectorName().isEmpty()) {

            model.addAttribute("error", "Le nom du secteur n'est pas renseigné");

            return "sector/" + link;

        }

        if (sector.getSectorRate().isEmpty()) {

            model.addAttribute("error", "La cotation n'est pas renseignée");

            return "sector/" + link;

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

            userFind = iSectorService.getSector(Long.valueOf(id)).getSectorAuthor();

            if (username.equals(userFind)) {
                return null;
            }

        } catch (Exception ex) {

            return "redirect:/sector/" + id;

        }

        return "redirect:/sector/" + id;

    }

}

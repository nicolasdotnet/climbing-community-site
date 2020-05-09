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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class SectorController {

    private final Logger log = LogManager.getLogger(SectorController.class);

    @Autowired
    private ISectorService iSectorService;

    @Autowired
    private ISpotService iSpotService;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    // show add sector form with spot
    @GetMapping("/user/spot/{id}/sector/add")
    public String showAddSectorForm(@PathVariable("id") int id, Model model) {

        log.debug("showAddSectorForm()");

        Spot spotFind = null;

        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
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

        String link = validateIsEmpty(sector, sublink, model);

        if (link != null) {
            
            Spot spotFind = null;
            
            try {
                spotFind = iSpotService.getSpot(Long.valueOf(id));
            } catch (Exception ex) {
                
            }
            model.addAttribute("spot", spotFind);
            
            return link;

        }

        Sector sectorNew = null;
        try {
            sectorNew = iSectorService.registerBySpot(sector.getSectorName(), sector.getSectorRate(), sector.getSectorDescription(), sector.getSectorAccessPath(), Long.valueOf(id), principal.getName());
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e);
            return "redirect:/user/spot/" + id + "/sector/add";
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/sector/" + Math.toIntExact(sectorNew.getSectorId());

    }

    // save sector without spot
    @PostMapping("/user/sectorSave/")
    public String saveSector(@ModelAttribute("sectorForm") Sector sector, @PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotForm : " + sector.getSectorName());

        Sector sectorNew = null;
        try {
            sectorNew = iSectorService.registerByDefault(sector.getSectorName(), sector.getSectorRate(), sector.getSectorDescription(), sector.getSectorAccessPath());

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/sector/" + Math.toIntExact(sectorNew.getSectorId());

    }

    public Sector addSectorByDefault(String sectorName, String sectorRate, String sectorDescription,
            String sectorAccessPath) {

        Sector sectorSave = new Sector();

        try {
            sectorSave = iSectorService.registerByDefault(sectorName, sectorRate, sectorDescription, sectorAccessPath);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorSave;
    }

    // show update sector form :
    @GetMapping("/user/sector/{id}/update")
    public String showUpdateSectorForm(@PathVariable("id") int id, Principal principal, Model model) {

        log.debug("showUpdateSectorForm() : {}", id);

        hasPermission(principal.getName(), id);

        Sector sectorFind = null;

        try {
            sectorFind = iSectorService.getSector(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
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

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "Secteur enregistré ! ");

        return "redirect:/sector/" + Math.toIntExact(sectorUpdate.getSectorId());
    }

    public Sector editSector(Sector sector) {

        Sector sectorEdit = new Sector();

        try {
            sectorEdit = iSectorService.edit(sector);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        return sectorEdit;
    }

    // show sector
    @GetMapping("/sector/{id}")
    public String showSector(@PathVariable("id") Long id, Principal principal, Model model) {

        log.debug("showSector() id: {}", id);

        System.out.println("showSector() id: {}" + id);

        Sector sectorFind = null;

        try {

            sectorFind = iSectorService.getSector(Long.valueOf(id));
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "redirect:/sectors";
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

    public Sector displaySector(Long id) {

        Sector sectorFind = new Sector();

        try {
            sectorFind = iSectorService.getSector(id);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorFind;
    }

    // sector list page by name
    @GetMapping("/user/sector/search")
    public String searchSector(Model model, @RequestParam("sectorName") String sectorName) {

        List<Sector> sectorList = null;

        try {
            sectorList = iSectorService.getAllSectorsByName(sectorName);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        System.out.println("le post marche !! searchSectorByMc");

        model.addAttribute("sectors", sectorList);

        return "/sector/list";
    }

    public List<Sector> displayAllSectorsByName(String sectorName) {

        List<Sector> sectorList = null;

        try {
            sectorList = iSectorService.getAllSectorsByName(sectorName);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorList;
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

            this.errorMessage = e.getMessage();
        }

        try {
            sectorList = iSectorService.getAllSectorsBySpot(spotFind);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        if (principal != null) {

            boolean owner = isOwner(principal.getName(), spotFind.getSpotAuthor().getUsername());
            model.addAttribute("owner", owner);

        } else {

            model.addAttribute("owner", false);
        }

        System.out.println("le post marche !! sector");

        model.addAttribute("sectors", sectorList);
        model.addAttribute("spot", spotFind);

        return "/sector/list";

    }

    public List<Sector> displayAllSectorsBySpot(Spot spot) {

        List<Sector> sectorList = null;

        try {
            sectorList = iSectorService.getAllSectorsBySpot(spot);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }
        return sectorList;
    }

    public List<Sector> displayAllSectors() {

        return iSectorService.getAllSectors();
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

            this.errorMessage = e.getMessage();
        }

        Long spotId = sectorFind.getSpot().getSpotId();

        try {
            iSectorService.delete(Long.valueOf(id));
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "secteur supprimé");

//        return "redirect:/sectors/"+ Math.toIntExact(spotId);
        return "redirect:/spot/" + Math.toIntExact(spotId) + "/sectors";

    }

    public String validateIsEmpty(Sector sector, String link, Model model) {

        if (sector.getSectorName().isEmpty()) {

            model.addAttribute("error", "name  isEmpty");

            return "sector/" + link;

        }

        if (sector.getSectorRate().isEmpty()) {

            model.addAttribute("error", "rate  isEmpty");

            return "sector/" + link;

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

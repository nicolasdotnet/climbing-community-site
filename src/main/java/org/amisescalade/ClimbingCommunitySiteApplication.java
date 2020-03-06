package org.amisescalade;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.amisescalade.controller.IComponentCategoryController;
import org.amisescalade.controller.ISectorCommentController;
import org.amisescalade.controller.ISectorComponentController;
import org.amisescalade.controller.ISectorController;
import org.amisescalade.controller.ISpotCommentController;
import org.amisescalade.controller.ISpotComponentController;
import org.amisescalade.controller.ISpotController;
import org.amisescalade.controller.ITopoCommentController;
import org.amisescalade.controller.ITopoController;
import org.amisescalade.controller.IUserCategoryController;
import org.amisescalade.controller.IUserController;
import org.amisescalade.controller.IWebpageCommentController;
import org.amisescalade.controller.IWebpageController;
import org.amisescalade.dao.ComponentCategoryRepository;
import org.amisescalade.dao.SectorCommentRepository;
import org.amisescalade.dao.SectorComponentRepository;
import org.amisescalade.dao.SectorRepository;
import org.amisescalade.dao.SpotCommentRepository;
import org.amisescalade.dao.SpotComponentRepository;
import org.amisescalade.dao.SpotRepository;
import org.amisescalade.dao.TopoCommentRepository;
import org.amisescalade.dao.TopoRepository;
import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.dao.UserRepository;
import org.amisescalade.dao.WebpageCommentRepository;
import org.amisescalade.dao.WebpageRepository;
import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.SectorComponent;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.SpotComponent;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;
import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;
import org.amisescalade.services.IComponentCategoryService;
import org.amisescalade.services.ISectorCommentService;
import org.amisescalade.services.ISectorComponentService;
import org.amisescalade.services.ISectorService;
import org.amisescalade.services.ISpotCommentService;
import org.amisescalade.services.ISpotComponentService;
import org.amisescalade.services.ISpotService;
import org.amisescalade.services.ITopoCommentService;
import org.amisescalade.services.ITopoService;
import org.amisescalade.services.IUserCategoryService;
import org.amisescalade.services.IUserService;
import org.amisescalade.services.IWebpageCommentService;
import org.amisescalade.services.IWebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ClimbingCommunitySiteApplication extends SpringBootServletInitializer implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private UserCategoryRepository userCategoryRepository;

    /*
	 * @Autowired private TopoRepository topoRepository;
     */
//	@Autowired
//	private WebpageRepository webpageRepository;

    /*
	 * @Autowired private SpotRepository spotRepository;
	 * 
	 * @Autowired private SectorRepository sectorRepository;
	 * 
	 * @Autowired private ComponentCategoryRepository componentCategoryRepository;
	 * 
	 * @Autowired private SpotComponentRepository spotComponentRepository;
	 * 
	 * @Autowired private SectorComponentRepository sectorComponentRepository;
	 * 
	 * @Autowired private SectorCommentRepository sectorCommentRepository;
	 * 
	 * @Autowired private SpotCommentRepository spotCommentRepository;
	 * 
	 * @Autowired private TopoCommentRepository topoCommentRepository;
     */
//	@Autowired
//	private WebpageCommentRepository webpageCommentRepository;
//	@Autowired
//	private IUserService iUserService;
//	@Autowired
//	private IUserCategoryService iUserCategoryService;

    /*
	 * @Autowired private ITopoService iTopoService;
     */
//	@Autowired
//	private IWebpageService iWebpageService;

    /*
	 * @Autowired private ISpotService iSpotService;
	 * 
	 * @Autowired private ISectorService iSectorService;
	 * 
	 * @Autowired private IComponentCategoryService iComponentCategoryService;
	 * 
	 * @Autowired private ISpotComponentService iSpotComponentService;
	 * 
	 * @Autowired private ISectorComponentService iSectorComponentService;
	 * 
	 * @Autowired private ISectorCommentService iSectorCommentService;
	 * 
	 * @Autowired private ISpotCommentService iSpotCommentService;
	 * 
	 * @Autowired private ITopoCommentService iTopoCommentService;
     */
//	@Autowired
//	private IWebpageCommentService iWebpageCommentService;
    @Autowired
    private IUserController iUserController;

    @Autowired
    private IUserCategoryController iUserCategoryController;

    @Autowired
    private IWebpageController iWebpageController;

    @Autowired
    private IWebpageCommentController iWebpageCommentController;

    @Autowired
    private ITopoController iTopoController;

    @Autowired
    private ISpotController iSpotController;

    @Autowired
    private ISectorController iSectorController;

    @Autowired
    private IComponentCategoryController iComponentCategoryController;

    @Autowired
    private ISpotComponentController iSpotComponentController;

    @Autowired
    private ISectorComponentController iSectorComponentController;

    @Autowired
    private ISectorCommentController iSectorCommentController;

    @Autowired
    private ISpotCommentController iSpotCommentController;

    @Autowired
    private ITopoCommentController iTopoCommentController;

    public static void main(String[] args) {

        SpringApplication.run(ClimbingCommunitySiteApplication.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {

        // insert first data
        // register UserCategory
        String label = "grimpeur";

        UserCategory uc1 = new UserCategory();

        uc1 = iUserCategoryController.addUserCategory(label);

        System.out.println(">>>>>>>>>>>>" + uc1.toString() + ">>>>>>>>>><");

        // method execution
        // register User
        String firstname = "nicolas";
        String lastname = "desdevises";
        String username = "nico";
        String password = "123";

        User uV1 = new User();

        uV1 = iUserController.signUpByDefault(firstname, lastname, username, password);

        System.out.println(iUserController.getErrorMessage());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register : " + uV1.toString() + "\n");

        // edit
        uV1.setFirstname("James");
        uV1.setLastname("Bond");

        User uV2 = iUserController.editUser(uV1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit : " + uV2.toString() + "\n");

        // displayOne User
        iUserController.displayUser(0L); // Ok entraine un log error en console

        System.out.println(iUserController.getErrorMessage());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        iUserController.displayUser(uV2.getUserId());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n displayOne : " + uV2.toString() + "\n");

        // sampleLogin User
        iUserController.signInUser("nico", "xxx"); // Ok entraine un log error en console
        iUserController.signInUser("nico", "123"); // Ok entraine pas un log error en console

        // displayAll User
        List<User> userList = iUserController.displayAllUsers();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            System.out.println("\n displayAll : " + user + "\n");

        }

        // register UserCategory
        label = "admin";

        UserCategory ucV1 = iUserCategoryController.addUserCategory(label);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register : " + ucV1.toString() + "\n");

        // edit UserCategory
        ucV1.setUserCategoryLabel("fake category");

        UserCategory ucV2 = iUserCategoryController.editUserCategory(ucV1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit : " + ucV2.toString() + "\n");

        uV2.setUserCategory(ucV2);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
        System.out.println("\n display uV2 modifed with ucV2 category : " + uV2.toString() + "\n");

        // displayAll UserCategory
        List<UserCategory> categoryList = iUserCategoryController.displayAllUserCategory();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n displayAll UserCategory : " + "\n");

        for (Iterator iterator = categoryList.iterator(); iterator.hasNext();) {
            UserCategory userCategory = (UserCategory) iterator.next();

            System.out.println("\n" + userCategory + "\n");
        }

        // display user with "grimper"
        UserCategory categoryFind = null;

        List<UserCategory> categoryListFind = iUserCategoryController.displayUserCategoryByLabel("grimpeur");

        for (Iterator iterator = categoryListFind.iterator(); iterator.hasNext();) {
            categoryFind = (UserCategory) iterator.next();

            System.out.println("\n" + categoryFind + "\n");
        }

        List<User> usersFind2 = iUserController.displayAllUsersByUserCategory(categoryFind);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = usersFind2.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            System.out.println("\n display All User with the " + user.getUserCategory() + " : " + user + "\n");

        }

        // register a topo
        String topoArea = "Arras";
        String topoTitle = "Roche d'Arras";
        String topoDescription = "Fake topo";
        User topoOwner = iUserController.displayUser(uV2.getUserId());

        Topo topo1 = iTopoController.addTopo(topoArea, topoTitle, topoDescription, topoOwner);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a topo : " + topo1.toString() + "\n");

        // edit a topo
        topo1.setTopoArea("L'Arrageois");
        topo1.setTopoTitle("Les roches d'Arras");

        Topo topo2 = iTopoController.editTopo(topo1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a topo : " + topo2.toString() + "\n");

        // displayByTitle topo
        List<Topo> topoList = iTopoController.displayTopoByTitle("Arras");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
            Topo topo = (Topo) iterator.next();

            System.out.println("\n displayByTitle topo (Arras) : " + topo.toString() + "\n");

        }

        // displayOne topo
        try {

            Topo topoFind = iTopoController.displayTopo(topo2.getTopoId());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

            System.out.println("\n displayOne topo : " + topoFind.toString() + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }

        // displayAll topo
        topoList = iTopoController.displayAllTopos();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
            Topo topo = (Topo) iterator.next();

            System.out.println("\n displayAll topo : " + topo.toString() + "\n");

        }

// register a webpage 
        String title = "Qui sommes nous ?";
        String body = "Nous sommes ....";
        User authorWebpage = iUserController.displayUser(uV1.getUserId());

        Webpage webpage1 = iWebpageController.addWebpage(title, body, authorWebpage);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a topo : " + webpage1.toString() + "\n");

        // edit a webpage
        webpage1.setWebpageBody(" Nouvelles version");

        Webpage webpage2 = iWebpageController.editWebpage(webpage1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a topo : " + webpage2.toString() + "\n");

        // displayAll webpage
        List<Webpage> webpageList = iWebpageController.displayAllWebpage();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = webpageList.iterator(); iterator.hasNext();) {
            Webpage webpage = (Webpage) iterator.next();

            System.out.println("\n displayAll topo : " + webpage.toString() + "\n");

        }

        // register a spot
        String spotName = "L'ange d'Arras";
        String spotRate = "A+";
        String spotDescription = "Spiderman à Arras";
        String spotAccessPath = "A1 puis direction Arras";
        String departement = "62";
        String country = "France";

        Spot spot1 = iSpotController.addSpot(spotName, spotRate, spotDescription, spotAccessPath, departement, country);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a spot : " + spot1.toString() + "\n");

        // edit a spot
        spot1.setSpotName("L'ange Arrasgeois");

        Spot spot2 = iSpotController.editSpot(spot1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a spot : " + spot2.toString() + "\n");

        // displayByName Spot
        List<Spot> spotList = iSpotController.displaySpotByName("Arras");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spot = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spot.toString() + "\n");

        }

        // displayOne spot
        try {

            Spot spotFind = iSpotController.displaySpot(spot2.getSpotId());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

            System.out.println("\n displayOne spot : " + spotFind.toString() + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }

        // displayAll spot
        spotList = iSpotController.displayAllSpots();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spot = (Spot) iterator.next();

            System.out.println("\n displayAll spot : " + spot.toString() + "\n");

        }

// register a sector without spot
        String sectorName = "L'ange Alpha d'Arras";
        String sectorRate = "A+";
        String sectorDescription = "firt time !";
        String sectorAccessPath = "A1 puis direction Arras";

        Sector sector1 = iSectorController.addSectorByDefault(sectorName, sectorRate, sectorDescription, sectorAccessPath);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a sector without spot : " + sector1.toString() + "\n");

// register a sector with a spot
        sectorName = "Le demon Alpha d'Arras";
        sectorRate = "A+";
        sectorDescription = "second time !";
        sectorAccessPath = "A1 puis direction Arras";
        Spot spot = iSpotController.displaySpot(spot2.getSpotId());

        Sector sectorBis = iSectorController.addSectorBySpot(sectorName, sectorRate, sectorDescription, sectorAccessPath, spot);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a sector with a spot : " + sectorBis.toString() + "\n");

        // edit a sector
        sector1.setSectorName("L'ange Alpha");

        Sector sector2 = iSectorController.editSector(sector1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a sector : " + sector2.toString() + "\n");

        // displayByName sector
        List<Sector> sectorList = iSectorController.displayAllSectorsByName("alpha");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = sectorList.iterator(); iterator.hasNext();) {
            Sector sector = (Sector) iterator.next();

            System.out.println("\n displayByName sector (alpha) : " + sector.toString() + "\n");

        }

        // displayOne sector
        try {

            Sector sectorFind = iSectorController.displaySector(sector2.getSectorId());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

            System.out.println("\n displayOne sector : " + sectorFind.toString() + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }

        // displayAll sector
        sectorList = iSectorController.displayAllSectors();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = sectorList.iterator(); iterator.hasNext();) {
            Sector sector = (Sector) iterator.next();

            System.out.println("\n displayAll sector : " + sector.toString() + "\n");

        }

        // displayAll sector for a spot
        spotList = iSpotController.displaySpotByName("Arras");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spotForSector = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spotForSector.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll sector for " + spotList.get(0).getSpotName() + " spot >>>><");

        sectorList = iSectorController.displayAllSectorsBySpot(spotList.get(0));

        if (sectorList == null) {

            System.out.println("\n Aucun résultat pour : " + spotList.get(0).getSpotName() + "\n");

        } else {

            for (Iterator iterator = sectorList.iterator(); iterator.hasNext();) {
                Sector sector = (Sector) iterator.next();

                System.out.println("\n displayAll sector for Arras : " + sector.toString() + "\n");

            }

        }

// register a component with a spot
        String componentCategoryLabel = "bloc";

        ComponentCategory cc1 = iComponentCategoryController.addComponentCategory(componentCategoryLabel);

        String componentCode = "xxxx";
        String componentName = "la petite roche";
        String componentRate = "AA+";
        String componentDescription = "componentDescription";
        ComponentCategory componentCategory = iComponentCategoryController.displayComponentCategory(cc1.getComponentCategoryId());
        spot = iSpotController.displaySpot(spot2.getSpotId());

        SpotComponent spotComponent1 = iSpotComponentController.addSpotComponent(componentCode, componentName, componentRate, componentDescription, componentCategory, spot);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a spotComponent with a spot : " + spotComponent1.toString() + "\n");

// edit a spotComponent
        spotComponent1.setComponentName("la petite roche Alpha");

        SpotComponent spotComponent2 = iSpotComponentController.editSpotComponent(spotComponent1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a spot component : " + spotComponent2.toString() + "\n");

// displayAll component for a lite spot
        spotList = iSpotController.displaySpotByName("Arras");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spotForComponent = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spotForComponent.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll component for " + spotList.get(0).getSpotName() + " spot >>>><");

        List<SpotComponent> spotComponentList = iSpotComponentController.displayAllSpotComponentBySpot(spotList.get(0));;

        if (spotComponentList == null) {

            System.out.println("\n Aucun résultat pour : " + spotList.get(0).getSpotName() + "\n");

        } else {

            for (Iterator iterator = spotComponentList.iterator(); iterator.hasNext();) {
                SpotComponent spotComponent = (SpotComponent) iterator.next();

                System.out.println("\n displayAll sector for the spot 'Arras' : " + spotComponent.toString() + "\n");

            }

        }

// register a component with a sector
        componentCode = "yyyy";
        componentName = "la petite robe noir";
        componentRate = "AA+";
        componentDescription = "componentDescription sector";
        componentCategory = iComponentCategoryController.displayComponentCategory(cc1.getComponentCategoryId());
        Sector sector = iSectorController.displaySector(sector2.getSectorId());

        SectorComponent sectorComponent1 = iSectorComponentController.addSectorComponent(componentCode, componentName, componentRate, componentDescription, componentCategory, sector);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a sectorComponent with a spot : " + sectorComponent1.toString() + "\n");

// edit a sectorComponent
        sectorComponent1.setComponentName("la petite robe Alpha");

        SectorComponent sectorComponent2 = iSectorComponentController.editSectorComponent(sectorComponent1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a sector component : " + sectorComponent2.toString() + "\n");

// displayAll component for a sector
        sectorList = iSectorController.displayAllSectorsByName("Alpha");

        for (Iterator iterator = sectorList.iterator(); iterator.hasNext();) {
            Sector sectorForComponent = (Sector) iterator.next();

            System.out.println("\n displayByName sector (Alpha) : " + sectorForComponent.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll component for " + sectorList.get(0).getSectorName() + " sector >>>><");

        List<SectorComponent> sectorComponentList = iSectorComponentController.displayAllSectorComponentBySector(sectorList.get(0));

        if (sectorComponentList == null) {

            System.out.println("\n Aucun résultat pour : " + sectorList.get(0).getSectorName() + "\n");

        } else {

            for (Iterator iterator = sectorComponentList.iterator(); iterator.hasNext();) {
                SectorComponent sectorComponent = (SectorComponent) iterator.next();

                System.out.println(
                        "\n displayAll component for the sector 'alpha' : " + sectorComponent.toString() + "\n");

            }

        }

// register a comment with a sector
        String commentBody = "commentBody";
        User authorComment = iUserController.displayUser(uV2.getUserId());
        Sector sectorComment0 = iSectorController.displaySector(sector2.getSectorId());

        SectorComment sectorComment1 = iSectorCommentController.addSectorComment(commentBody, authorComment,
                sectorComment0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a sectorComment with a sector : " + sectorComment1.toString() + "\n");

// edit a sectorComment
        sectorComment1.setCommentBody("comment -> la petite robe Alpha");

        SectorComment sectorComment2 = iSectorCommentController.editSectorComponent(sectorComment1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a sector comment : " + sectorComment2.toString() + "\n");

// displayAll comment for a sector
        sectorList = iSectorController.displayAllSectorsByName("Alpha");

        for (Iterator iterator = sectorList.iterator(); iterator.hasNext();) {
            Sector sectorForComment = (Sector) iterator.next();

            System.out.println("\n displayByName sector (Alpha) : " + sectorForComment.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll comment for " + sectorList.get(0).getSectorName() + " sector >>>><");

        List<SectorComment> sectorCommentList = iSectorCommentController.displayAllSectorCommentBySector(sectorList.get(0));

        if (sectorCommentList == null) {

            System.out.println("\n Aucun résultat pour : " + sectorList.get(0).getSectorName() + "\n");

        } else {

            for (Iterator iterator = sectorCommentList.iterator(); iterator.hasNext();) {
                SectorComment sectorComment = (SectorComment) iterator.next();

                System.out.println("\n displayAll comment for the sector 'alpha' : " + sectorComment.toString() + "\n");

            }

        }

// register a comment with a spot
        commentBody = "commentBody";
        authorComment = iUserController.displayUser(uV2.getUserId());
        Spot spotComment0 = iSpotController.displaySpot(spot2.getSpotId());

        SpotComment spotComment1 = iSpotCommentController.addSpotComment(commentBody, authorComment,
                spotComment0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a spotComment with a spot : " + sectorComment1.toString() + "\n");

// edit a sectorComment
        spotComment1.setCommentBody("comment -> le petit daemon !!");

        SpotComment spotComment2 = iSpotCommentController.editSectorComponent(spotComment1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a spot comment : " + spotComment2.toString() + "\n");

// displayAll comment for a spot
        try {

            spotList = iSpotController.displaySpotByName("Arras");

        } catch (Exception e) {
            // TODO: handle exception
        }

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spotForComment = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spotForComment.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll comment for " + spotList.get(0).getSpotName() + " spot >>>><");

        List<SpotComment> spotCommentList = iSpotCommentController.displayAllSpotCommentBySpot(spotList.get(0));

        if (spotCommentList == null) {

            System.out.println("\n Aucun résultat pour : " + spotList.get(0).getSpotName() + "\n");

        } else {

            for (Iterator iterator = spotCommentList.iterator(); iterator.hasNext();) {
                SpotComment spotComment = (SpotComment) iterator.next();

                System.out.println("\n displayAll comment for the spot 'arras' : " + spotComment.toString() + "\n");

            }

        }

// register a comment with a topo
        commentBody = "commentBody";
        authorComment = iUserController.displayUser(uV2.getUserId());
        Topo topoComment0 = iTopoController.displayTopo(topo2.getTopoId());

        TopoComment topoComment1 = iTopoCommentController.addTopoComment(commentBody, authorComment,
                topoComment0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a topoComment with a topo : " + topoComment1.toString() + "\n");

// edit a sectorComment
        topoComment1.setCommentBody("comment -> un model de topo :) !!");

        TopoComment topoComment2 = iTopoCommentController.editTopoComment(topoComment1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a topo comment : " + topoComment2.toString() + "\n");

// displayAll comment for a topo
        try {

            topoList = iTopoController.displayTopoByTitle("Arras");

        } catch (Exception e) {
            // TODO: handle exception
        }

        for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
            Topo topoForComment = (Topo) iterator.next();

            System.out.println("\n displayByName topo (Arras) : " + topoForComment.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll comment for " + topoList.get(0).getTopoTitle() + " spot >>>><");

        List<TopoComment> topoCommentList = iTopoCommentController.displayAllTopoCommentByTopo(topoList.get(0));

        if (topoCommentList == null) {

            System.out.println("\n Aucun résultat pour : " + topoList.get(0).getTopoTitle() + "\n");

        } else {

            for (Iterator iterator = topoCommentList.iterator(); iterator.hasNext();) {
                TopoComment topoComment = (TopoComment) iterator.next();

                System.out.println("\n displayAll comment for the topo 'arras' : " + topoComment.toString() + "\n");

            }

        }

// register a comment with a webpage
        commentBody = "commentBody";
        authorComment = iUserController.displayUser(uV2.getUserId());
        Webpage webpageComment0 = iWebpageController.displayWebpage(webpage2.getWebpageId());

        WebpageComment webpageComment1 = iWebpageCommentController.addWebpageComment(commentBody, authorComment,
                webpageComment0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a webpageComment with a webpage : " + webpageComment1.toString() + "\n");

// edit a Comment

        /*
		 * webpageComment1.setCommentBody("comment -> je ne comprend rien ! :)");
		 * 
		 * WebpageComment webpageComment2 =
		 * iWebpageCommentService.edit(webpageComment1);
		 * 
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		 * 
		 * System.out.println("\n edit a webpage comment : " +
		 * webpageComment2.toString() + "\n");
         */
// displayAll comment for a webpage
        Webpage webpageFind = null;

        try {

            webpageFind = iWebpageController.displayWebpage(webpage2.getWebpageId());

        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(">>>>>> displayAll comment for " + webpageFind.getWebpageTitle() + " >>>><");

        List<WebpageComment> webpageCommentList = iWebpageCommentController
                .displayAllWebpageCommentByWebpage(webpageFind);

        if (webpageCommentList == null) {

            System.out.println("\n Aucun résultat pour : " + webpageFind.getWebpageTitle() + "\n");

        } else {

            System.out.println("\n displayAll comment \n");

            for (Iterator iterator = webpageCommentList.iterator(); iterator.hasNext();) {

                WebpageComment webpageComment = (WebpageComment) iterator.next();

                System.out.println("\n displayAll comment for the page " + webpageFind.getWebpageTitle() + " : "
                        + webpageComment.toString() + "\n");

            }

            System.out.println("\n displayAll comment \n");

        }

    }
}

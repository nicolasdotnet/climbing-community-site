package org.amisescalade;

import java.util.Iterator;
import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.Comment;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.amisescalade.services.ISpotService;
import org.amisescalade.services.ITopoService;
import org.amisescalade.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.amisescalade.services.ICommentService;
import org.amisescalade.services.IRoleService;

@SpringBootApplication
public class ClimbingCommunitySiteApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iUserCategoryService;

    @Autowired
    private ITopoService iTopoService;

    @Autowired
    private ISpotService iSpotService;

    @Autowired
    private ICommentService iCommentService;

    public static void main(String[] args) {

        SpringApplication.run(ClimbingCommunitySiteApplication.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {
// https://www.grimper.com/site-escalade-ceuse#panel-topos
        // insert first data
        // register Role
        String label = "grimpeur";

        Role uc1 = new Role();

        uc1 = iUserCategoryService.register(label);

        System.out.println(">>>>>>>>>>>>" + uc1.toString() + ">>>>>>>>>><");

        // method execution
        // register User
        String firstname = "nicolas";
        String lastname = "desdevises";
        String username = "nico";
        String password = "123";

        User uV1 = new User();

        uV1 = iUserService.registerByDefault(firstname, lastname, username, password);
  

//        System.out.println(iUserService.getErrorMessage());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register : " + uV1.toString() + "\n");

        // edit
        uV1.setFirstname("James");
        uV1.setLastname("Bond");

        User uV2 = iUserService.edit(uV1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit : " + uV2.toString() + "\n");

        // displayOne User
//        iUserService.getUser(0L); // Ok entraine un log error en console

//        System.out.println(iUserService.getErrorMessage());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        iUserService.getUser(uV2.getUserId());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n displayOne : " + uV2.toString() + "\n");

        // sampleLogin User
//        iUserService.sampleLogin("nico", "xxx"); // Ok entraine un log error en console
//        iUserService.sampleLogin("nico", "123"); // Ok entraine pas un log error en console

        // displayAll User
        List<User> userList = iUserService.getAllUsers();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            System.out.println("\n displayAll : " + user + "\n");

        }

        // register Role
        label = "fake category";

        Role ucV1 = iUserCategoryService.register(label);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register : " + ucV1.toString() + "\n");

        // edit Role
        ucV1.setRoleName("admin");

        Role ucV2 = iUserCategoryService.edit(ucV1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit : " + ucV2.toString() + "\n");

        uV2.setRole(ucV2);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
        System.out.println("\n display uV2 modifed with ucV2 category : " + uV2.toString() + "\n");

        // displayAll Role
        List<Role> categoryList = iUserCategoryService.getAllUserCategory();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n displayAll UserCategory : " + "\n");

        for (Iterator iterator = categoryList.iterator(); iterator.hasNext();) {
            Role userCategory = (Role) iterator.next();

            System.out.println("\n" + userCategory + "\n");
        }

        // display user with "grimper"
        Role categoryFind = null;

        List<Role> categoryListFind = iUserCategoryService.getUserCategoryByLabel("grimpeur");

        for (Iterator iterator = categoryListFind.iterator(); iterator.hasNext();) {
            categoryFind = (Role) iterator.next();

            System.out.println("\n" + categoryFind + "\n");
        }

        List<User> usersFind2 = iUserService.getUsersByCategory(categoryFind);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = usersFind2.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            System.out.println("\n display All User with the " + user.getRole() + " : " + user + "\n");

        }

        // register a topo
        String topoArea = "Arras";
        String topoTitle = "Roche d'Arras";
        String topoDescription = "Fake topo";
        User topoOwner = iUserService.getUser(uV2.getUserId());

        Topo topo1 = iTopoService.register(topoArea, topoTitle, topoDescription, topoOwner);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a topo : " + topo1.toString() + "\n");

        // edit a topo
        topo1.setTopoArea("L'Arrageois");
        topo1.setTopoTitle("Les roches d'Arras");

        Topo topo2 = iTopoService.edit(topo1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a topo : " + topo2.toString() + "\n");

        // displayByTitle topo
        List<Topo> topoList = iTopoService.getTopoByTitle("Arras");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
            Topo topo = (Topo) iterator.next();

            System.out.println("\n displayByTitle topo (Arras) : " + topo.toString() + "\n");

        }

        // displayOne topo
        try {

            Topo topoFind = iTopoService.getTopo(topo2.getTopoId());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

            System.out.println("\n displayOne topo : " + topoFind.toString() + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }

        // displayAll topo
        topoList = iTopoService.getAllTopos();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
            Topo topo = (Topo) iterator.next();

            System.out.println("\n displayAll topo : " + topo.toString() + "\n");

        }

        // register a spot
        String spotName = "L'ange d'Arras";
        String spotRate = "6A+";
        String spotDescription = "Spiderman à Arras";
        String spotAccessPath = "A1 puis direction Arras";
        String departement = "62";
        String country = "France";
        String sectorCount = "4";
        String sectorDescription= "La particularité du grès du coin, c’est qu’il ne présente que peu de prises : des trous, des plats, peu de réglettes... ";
        String routeCount = "50";
        String routeDescription = " avec environ 1.600 passages, et encore du potentiel, il y en a pour tous les goûts et tous les niveaux.";

        Spot spot1 = iSpotService.register(spotName, spotRate, spotDescription, spotAccessPath, departement, country,sectorCount, sectorDescription, routeCount, routeDescription, uV2);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a spot : " + spot1.toString() + "\n");

        // edit a spot
        spot1.setSpotName("L'ange Arrasgeois");

//        Spot spot2 = iSpotService.editSpot(spot1);
        Spot spot2 = spot1;

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a spot : " + spot2.toString() + "\n");

        // displayByName Spot
        List<Spot> spotList = iSpotService.getAllSpotsByName("Arras");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spot = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spot.toString() + "\n");

        }

        // displayOne spot
        try {

            Spot spotFind = iSpotService.getSpot(spot2.getSpotId());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

            System.out.println("\n displayOne spot : " + spotFind.toString() + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }

        // displayAll spot
//        spotList = iSpotService.getAllSpots();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spot = (Spot) iterator.next();

            System.out.println("\n displayAll spot : " + spot.toString() + "\n");

        }

// register a comment with a spot
        String commentBody = "commentBody";
        User authorComment = iUserService.getUser(uV2.getUserId());
        Spot spotComment0 = iSpotService.getSpot(spot2.getSpotId());

        Comment spotComment1 = iCommentService.register(commentBody, authorComment,
                spotComment0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n register a spotComment with a spot : " + spotComment1.toString() + "\n");

// edit a spotComment
        spotComment1.setCommentBody("comment -> le petit daemon !!");

        Comment spotComment2 = iCommentService.edit(spotComment1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

        System.out.println("\n edit a spot comment : " + spotComment2.toString() + "\n");

// displayAll comment for a spot
        try {

            spotList = iSpotService.getAllSpotsByName("Arras");

        } catch (Exception e) {
            // TODO: handle exception
        }

        for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
            Spot spotForComment = (Spot) iterator.next();

            System.out.println("\n displayByName spot (Arras) : " + spotForComment.toString() + "\n");

        }

        System.out.println(">>>>>> displayAll comment for " + spotList.get(0).getSpotName() + " spot >>>><");

        List<Comment> spotCommentList = iCommentService.getAllCommentBySpot(spotList.get(0));

        if (spotCommentList == null) {

            System.out.println("\n Aucun résultat pour : " + spotList.get(0).getSpotName() + "\n");

        } else {

            for (Iterator iterator = spotCommentList.iterator(); iterator.hasNext();) {
                Comment spotComment = (Comment) iterator.next();

                System.out.println("\n displayAll comment for the spot 'arras' : " + spotComment.toString() + "\n");

            }

        }

    }
}

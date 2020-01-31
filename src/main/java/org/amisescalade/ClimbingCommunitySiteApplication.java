package org.amisescalade;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.amisescalade.dao.SpotRepository;
import org.amisescalade.dao.TopoRepository;
import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.dao.UserRepository;
import org.amisescalade.dao.WebpageRepository;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.amisescalade.entity.Webpage;
import org.amisescalade.services.ISpotService;
import org.amisescalade.services.ITopoService;
import org.amisescalade.services.IUserCategoryService;
import org.amisescalade.services.IUserService;
import org.amisescalade.services.IWebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimbingCommunitySiteApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCategoryRepository userCategoryRepository;
	
	@Autowired
	private TopoRepository topoRepository;
	
	@Autowired
	private WebpageRepository webpageRepository;
	
	@Autowired
	private SpotRepository spotRepository;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IUserCategoryService iUserCategoryService;
	
	@Autowired
	private ITopoService iTopoService;
	
	@Autowired
	private IWebpageService iWebpageService;
	
	@Autowired
	private ISpotService iSpotService;
	

	public static void main(String[] args) {
		
		SpringApplication.run(ClimbingCommunitySiteApplication.class, args);	
	}

//	@Override
	public void run(String... args) throws Exception {
		
		
		// insert data
		
		UserCategory uc1 = userCategoryRepository.save(new UserCategory(new Date(), "grimpeur"));
		
		
		// method execution
		
		// register User
		User uV1 = iUserService.register(new User(new Date(), "nicolas", "desdevises", "nico", "123", uc1));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		System.out.println("\n register : "+uV1.toString()+"\n");
		
		// edit 
		uV1.setFirstname("James");
		uV1.setLastname("Bond");
		
		User uV2 = iUserService.edit(uV1);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		System.out.println("\n edit : "+uV2.toString()+"\n");
		
		// displayOne User
		
		User test = new User(00000L,new Date(), "test");
		
		try {
		
		iUserService.displayOne(test); // Ok entraine un log error en console
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		iUserService.displayOne(uV2);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		System.out.println("\n displayOne : "+uV2.toString()+"\n");
		
		// sampleLogin User
		
		User test2 = new User (new Date(), "nicolas", "desdevises", "nico", "1234", uc1);
		
		try {
		
		iUserService.sampleLogin(test2); // Ok entraine un log error en console
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// displayAll User
		
		List<User> userList = iUserService.displayAll();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			
			System.out.println("\n displayAll : "+user+"\n");
			
			
		}
		
		// register UserCategory
		
		UserCategory ucV1 = iUserCategoryService.register(new UserCategory(new Date(), "admin"));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		System.out.println("\n register : "+ucV1.toString()+"\n");
		
		// edit UserCategory
		
		ucV1.setUserCategoryLabel("fake category");

		UserCategory ucV2 = iUserCategoryService.edit(ucV1);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");

		System.out.println("\n edit : " + ucV2.toString() + "\n");
		
		uV2.setUserCategory(ucV2);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		System.out.println("\n display uV2 modifed with ucV2 category : "+uV2.toString()+"\n");
		
		// displayAll UserCategory
		
		List<UserCategory> categoryList = iUserCategoryService.displayAll();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		System.out.println("\n displayAll UserCategory : "+ "\n");
		
		for (Iterator iterator = categoryList.iterator(); iterator.hasNext();) {
			UserCategory userCategory = (UserCategory) iterator.next();
			
			System.out.println("\n"+userCategory+"\n");
		}
		
		// display user with "grimper"
		
		UserCategory categoryFind = iUserCategoryService.displayOneUserCategory("grimpeur");		
		
		List<User> usersFind2 = iUserService.displayByCategory(categoryFind);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		
		  for (Iterator iterator = usersFind2.iterator(); iterator.hasNext();) { User
		  user = (User) iterator.next();
		  
		  System.out.println("\n display All User with the "+user.
		  getUserCategory() +" : "+user+"\n");
		  
		  }
		  
		  
		  // register a topo 
		  
		  Topo topo1 = iTopoService.register(new Topo(new Date(), "Arras", "Roche d'Arras", "Fake topo", uV1));
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n register a topo : "+topo1.toString()+"\n");
		  
		  // edit a topo
		  
		  topo1.setTopoArea("L'Arrageois");
		  topo1.setTopoTitle("Les roches d'Arras");
		  
		  Topo topo2 = iTopoService.edit(topo1);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n edit a topo : " + topo2.toString() + "\n");
		  
		  
		// displayByTitle topo
		  
		  List<Topo> topoList = iTopoService.displayByTitle("Arras");
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
				Topo topo = (Topo) iterator.next();
				
				System.out.println("\n displayByTitle topo (Arras) : " + topo.toString()+ "\n");
				
			}
		  
		  // displayOne topo
		  
		  try {
		  
			  Topo topoFind = iTopoService.displayOne(topo2.getTopoId());
			  
			  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n displayOne topo : " + topoFind.toString()+ "\n");
		  
			}catch (Exception e) {
				// TODO: handle exception
			}
		  
		  // displayAll topo
		  
		 topoList = iTopoService.displayAll();
		 
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  for (Iterator iterator = topoList.iterator(); iterator.hasNext();) {
			Topo topo = (Topo) iterator.next();
			
			System.out.println("\n displayAll topo : " + topo.toString()+ "\n");
			
		}
		  
		  
// register a webpage 
		  
		  Webpage webpage1 = iWebpageService.register(new Webpage (new Date(), "Qui sommes nous ?", "Nous sommes ....", uV1));
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n register a topo : "+webpage1.toString()+"\n");
		  
		  // edit a webpage
		  
		  webpage1.setWebpageBody(" Nouvelles version");
		  
		  Webpage webpage2 = iWebpageService.edit(webpage1);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n edit a topo : " + webpage2.toString() + "\n");
		  
		  
		  // displayAll webpage
		  
		  List<Webpage> webpageList = iWebpageService.displayAll();
		 
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  for (Iterator iterator = webpageList.iterator(); iterator.hasNext();) {
			  Webpage webpage = (Webpage) iterator.next();
			
			System.out.println("\n displayAll topo : " + webpage.toString()+ "\n");
			
		}
		  
		  
		  Spot spot1 = iSpotService.register(new Spot(new Date(), "L'ange d'Arras", "A+", "Spiderman à Arras","A1 puis direction Arras", "62", "France"));
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n register a spot : "+spot1.toString()+"\n");
		  
		  // edit a spot
		  
		  spot1.setSpotName("L'ange Arrasgeois");
		  
		  Spot spot2 = iSpotService.edit(spot1);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n edit a spot : " + spot2.toString() + "\n");
		  
		  
		// displayByName Spot
		  
		  List<Spot> spotList = iSpotService.displayBySpotname("Arras");
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
				Spot spot = (Spot) iterator.next();
				
				System.out.println("\n displayByName spot (Arras) : " + spot.toString()+ "\n");
				
			}
		  
		  // displayOne spot
		  
		  try {
		  
			  Spot spotFind = iSpotService.displayOne(spot2.getSpotId());
			  
			  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  System.out.println("\n displayOne spot : " + spotFind.toString()+ "\n");
		  
			}catch (Exception e) {
				// TODO: handle exception
			}
		  
		  // displayAll topo
		  
		 spotList = iSpotService.displayAll();
		 
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		  
		  for (Iterator iterator = spotList.iterator(); iterator.hasNext();) {
			Spot spot = (Spot) iterator.next();
			
			System.out.println("\n displayAll spot : " + spot.toString()+ "\n");
			
		}
		  
		  
		  
		  
		
				
		
	}

}

package com.mar.toolshare;

import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.impl.ItemServiceImpl;
import com.mar.toolshare.service.entities.impl.PastRentalServiceImpl;
import com.mar.toolshare.service.entities.impl.RentalServiceImp;
import com.mar.toolshare.service.entities.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;

@SpringBootApplication (scanBasePackages = {"com.mar.toolshare"})
public class ToolshareApplication {

	@Autowired
	ItemServiceImpl itemService;

	@Autowired
	RentalServiceImp rentalService;

	@Autowired
	PastRentalServiceImpl pastRentalService;

	@Autowired
	UserServiceImpl userService;

	public static void main(String[] args) {
		SpringApplication.run(ToolshareApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
        return args -> {
        	
			Item i1 = new Item("Driller AEG BBH 18",1," Powerful 20-volt max motor provides enough power for a full range of applications and attachments\n" +
					"Compact and lightweight design allows users to carry out drilling/driving tasks in confined spaces and with ease\n" +
					"Part of the 20-volt max system a system that demands attention\n" +
					"Included Components: (1) BDCDMT120 20V MAX* Power Unit, (1) BDCMTDD Drill/Driver Attachment, (1) 20V MAX* Lithium Ion Battery, (1) 20V MAX* Charger, (1) Double-ended Bit\n" +
					"Matrix Quick Connect System\n" +
					"Powerful 20v MAX Motor provides enough power for a full range of applications & attachments\n" +
					"Compact and lightweight design\n" +
					"Part of the 20V MAX System - A System that Demands Attention ");
			Item i2 = new Item("Mitre Saw Dewalt DWS716XPS",2,"The 15 Amp motor in this 12 in. Double-Bevel Compound Miter Saw drives 3,800 rpm to deliver extended power and durability. The integrated CUTLINE feature (LED work light system) provides adjustment-free cut line indication for accuracy and visibility. This saw has a stainless-steel miter detent plate with 14 positive stops and cam miter lock system that provides repeatable accuracy and durability with easy adjustments. Tall sliding fences support 6-1/2 in. of base molding vertically and 6-5/8 in. of crown molding vertically nested. High-efficiency dust duct is concentrated at the point of cut for maximum collection. Its lightweight design and built-in carry handle provide portability. ");
			Item i3 = new Item("Reinforced Service Cart 2400 Lb. Capacity 24 x 30",3,"TWO-SHELF EXTRA HEAVY DUTY REINFORCED STEEL SERVICE CARTS\n" +
					"30\"L x 24\"W Cart with 6\" Casters\n" +
					"Extra heavy duty service carts transport heavier items with ease. Steel stock carts feature all-welded construction with 12 gauge steel shelves. Shelves feature under bracing reinforcement for enhanced durability. Tubular handle with smooth radius bend for comfort and uniform appearance. Flush top shelf transports larger, bulky items with ease. Bottom shelves include 1-1/2\" retaining edges. 25\" clearance between shelves. Moves easily on phenolic casters (2 swivel, 2 rigid).");
			Item i4 = new Item("Nailgun DCN692N-XJ",4," First fix, gas-free framing nail gun featuring brushless motor technology to increase tool life, durability and efficiency. 2-speeds optimise the gun for firing 50-90mm nails, allow a longer run time, quickens readiness to fire, reduces recoil and improves durability when firing short nails. Mechanical operation reduces running costs and offers consistent performance at temperatures between -20°C and 50°C and minimal cleaning or servicing requirements. Features sequential and bump modes for precision or production speed. Versatile 30-34° magazine will accept most clipped head and off-centre round head paper tape or wire weld collated framing nails. Ergonomic design allows the nail gun to fit easily between a 400mm centre stud. Part of the intelligent XR Li-ion series designed for efficiency and making applications faster.\n" +
					"\n" +
					"    Fires 18ga 50-90mm Nails\n" +
					"    Fires up to 120/min\n" +
					"    Bump & Sequential Trigger Action\n" +
					"    Tool-Free Jam Clearance\n" +
					"    State of Charge Indicator\n" +
					"    Reversible Belt / Rafter Hook\n" +
					"    Does Not Include Battery or Charger\n");
			Item i5 = new Item("DEWALT Impact Driver DCF887B",5," Dewalt built Brushless Motor, Compact, Lightweight Design for tight spaces\n" +
					"20V MAX XR Impact Driver Kit, Brushless, 3-Speed, 1/4-Inch\n" +
					"Variable speed trigger, no load speed 0 to 1000, 2800, 3250\n" +
					"3 speed settings for versatility with Precision Drive for added Control\n" +
					"(3) LED lights with 20 second delay after trigger release\n" +
					"No battery or charger Included ");

			itemService.saveAll(Arrays.asList(i1,i2,i3,i4,i5));

			String pass = new BCryptPasswordEncoder().encode("a");
			UserAccount a = new UserAccount("a", "Admin", " ", "","" ,"","admin@gmail.com", pass, true, "ROLE_ADMIN", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userService.save(a);

			String passb = new BCryptPasswordEncoder().encode("b");
			UserAccount b = new UserAccount("b", "Christopher","Faulkner", "4834  Shinn Street","New York","10023", "ChristopherNFaulkner@gmail.com", passb, true, "ROLE_MANAGER", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userService.save(b);

			String passbb = new BCryptPasswordEncoder().encode("bb");
			UserAccount bb = new UserAccount("bb", "Cheri","Mathis","3832  Morningview Lane","New York","10007","CherriMMathis@gmail.com", passbb, true, "ROLE_MANAGER", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userService.save(bb);

			String passc = new BCryptPasswordEncoder().encode("c");
			UserAccount c = new UserAccount("userc", "Kenneth", "Carolina", "579  Hoffman Avenue", "New York", "10016","KennethCCarolina@dayrep.com", passc, true, "ROLE_USER", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userService.save(c);

			Rental r1 = new Rental(c,i1, LocalDateTime.now());
			Rental r2 = new Rental(c,i2, LocalDateTime.now().minusDays(1));
			Rental r3 = new Rental(c,i5, LocalDateTime.now().minusDays(4));
			Rental r4 = new Rental(c,i3, LocalDateTime.now().minusDays(2));
			rentalService.saveAll(Arrays.asList(r1,r2,r3,r4));

			PastRental pr1 = new PastRental(c, i3, LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(1));
			PastRental pr2 = new PastRental(c, i4, LocalDateTime.now().minusMinutes(200), LocalDateTime.now().minusDays(100));
			pastRentalService.saveAll(Arrays.asList(pr1,pr2));
        };
    };
}

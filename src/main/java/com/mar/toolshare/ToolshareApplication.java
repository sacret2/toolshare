package com.mar.toolshare;

import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.databases.dao.UserAccountRepository;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;
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
	ItemRepository itemRepository;

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToolshareApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
        return args -> {
        	
			Item i1 = new Item("i1",1,"desc1");
			Item i2 = new Item("i2",2,"desc2");
			Item i3 = new Item("i3",3,"desc3");
			Item i4 = new Item("i4",4,"desc4");
			Item i5 = new Item("i5",5,"desc5");

			itemRepository.saveAll(Arrays.asList(i1,i2,i3,i4,i5));

			String pass = new BCryptPasswordEncoder().encode("a");
			UserAccount a = new UserAccount("a", "a", "a", "a", pass, true, "ROLE_ADMIN", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userAccountRepository.save(a);

			String passb = new BCryptPasswordEncoder().encode("b");
			UserAccount b = new UserAccount("b", "b","b", "b", passb, true, "ROLE_MANAGER", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userAccountRepository.save(b);

			String passc = new BCryptPasswordEncoder().encode("c");
			UserAccount c = new UserAccount("c", "c", "c", "c", passc, true, "ROLE_USER", new LinkedList<Rental>(),new LinkedList<PastRental>());
			userAccountRepository.save(c);

			Rental r1 = new Rental(a,i1, LocalDateTime.now());
			Rental r2 = new Rental(a,i2, LocalDateTime.now().minusDays(1));

			rentalRepository.saveAll(Arrays.asList(r1,r2));
        };
    };
}

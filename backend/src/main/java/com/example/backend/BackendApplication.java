package com.example.backend;

import com.example.backend.models.*;
import com.example.backend.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.backend.repository")
public class BackendApplication {

	@Autowired
	private BrodRepository brodRepository;
	@Autowired
	private VikendicaRepository vikendicaRepository;
	@Autowired
	private CasRepository casRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AkcijaRepository akcijaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*/**").allowedOrigins("http://localhost:3000");
			}
		};
	}


	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			brodRepository.deleteAll();
			casRepository.deleteAll();
			vikendicaRepository.deleteAll();
			userRepository.deleteAll();
			akcijaRepository.deleteAll();

			Brod brod = new Brod();
			Vikendica vikendica = new Vikendica();
			Cas cas = new Cas();

			brod.setNaziv("Brod Blue Sea");
			brod.setAdresa("adresa1");
			brod.setPromoOpis("PromoOpis1");
			brod.setSlike("brod-jedan.jpeg");
			brod.setMaxBrojOsoba(3);
//			brod.setSlobodniTermini();
			brod.setPravilaPonasanja("pravila1");
			brod.setOpremaUzRezervaciju("oprema1");
			brod.setCenovnikInfo("cenovnik1");
			brod.setUsloviOtkaza("uslovi1");
			brod.setTip("tip1");
			brod.setBrojMotora("AHC41");
			brod.setSnagaMotora("66KW");
			brod.setMaxSpreed(200);
			brod.setNavigacionaOprema("Mapa;Kompas");
			brod.setZbirOcena(0);
			brod.setUkupnoOcena(0);
			brodRepository.saveAndFlush(brod);


			Brod brod1 = new Brod();
			brod1.setNaziv("Brod Monte");
			brod1.setAdresa("adresa2");
			brod1.setPromoOpis("PromoOpis2");
			brod1.setSlike("brod-dva.jpg");
			brod1.setMaxBrojOsoba(600);
//			brod1.setSlobodniTermini();
			brod1.setPravilaPonasanja("Lepo ponasanje");
			brod1.setOpremaUzRezervaciju("opema2");
			brod1.setCenovnikInfo("cenovnik2");
			brod1.setUsloviOtkaza("uslovi1");
			brod1.setTip("tip2");
			brod1.setBrojMotora("15GHP");
			brod1.setSnagaMotora("6600KW");
			brod1.setMaxSpreed(210);
			brod1.setNavigacionaOprema("Mapa;Kompas;Durbin");
			brod1.setZbirOcena(0);
			brod1.setUkupnoOcena(0);
			brodRepository.saveAndFlush(brod1);


			vikendica.setNaziv("vikendica Zlatar");
			vikendica.setAdresa("adresa bb");
			vikendica.setPromoOpis("Promo opis vikendice Zlatar");
			vikendica.setSlike("vikendica-jedan.jpg");
			vikendica.setMaxBrojOsoba(3);
//			vikendica.setSlobodniTermini();
			vikendica.setPravilaPonasanja("pravila1");
			vikendica.setOpremaUzRezervaciju("oprema1");
			vikendica.setCenovnikInfo("cenovnik3");
			vikendica.setUsloviOtkaza("uslovi1");
			vikendica.setBrojKreveta(3);
			vikendica.setBrojSoba(2);
			vikendica.setZbirOcena(0);
			vikendica.setUkupnoOcena(0);
			vikendicaRepository.saveAndFlush(vikendica);

			Vikendica vikendica1 = new Vikendica();
			vikendica1.setNaziv("vikendica Tara");
			vikendica1.setAdresa("adresa Tara bb");
			vikendica1.setPromoOpis("PromoOpis vikendice Tare");
			vikendica1.setSlike("vikendica-dva.jpeg");
			vikendica1.setMaxBrojOsoba(3);
//			vikendica1.setSlobodniTermini();
			vikendica1.setPravilaPonasanja("pravila1");
			vikendica1.setOpremaUzRezervaciju("oprema1");
			vikendica1.setCenovnikInfo("cenovnik1");
			vikendica1.setUsloviOtkaza("uslovi1");
			vikendica1.setBrojKreveta(10);
			vikendica1.setBrojSoba(3);
			vikendica1.setZbirOcena(0);
			vikendica1.setUkupnoOcena(0);
			vikendicaRepository.saveAndFlush(vikendica1);

			cas.setNaziv("cas1");
			cas.setAdresa("Adresa nalazista bb");
			cas.setPromoOpis("PromoOpis1");
//			cas.setSlike(Arrays.asList("brod-jedan.jpeg", "vikendica-jedan.jpg"));
			cas.setMaxBrojOsoba(3);
//			cas.setSlobodniTermini();
			cas.setPravilaPonasanja("pravila1");
			cas.setOpremaUzRezervaciju("oprema1");
			cas.setCenovnikInfo("cenovnik1");
			cas.setUsloviOtkaza("uslovi1");
			cas.setKratkaBiografijaInstruktora("Instruktor Igor.Sa iskustvom od 10 godina");
			cas.setZbirOcena(0);
			cas.setUkupnoOcena(0);
			casRepository.saveAndFlush(cas);

			Cas cas1 = new Cas();
			cas1.setNaziv("cas2");
			cas1.setAdresa("adresa1");
			cas1.setPromoOpis("Uzbudljiv cas");
//			cas1.setSlike(Arrays.asList("brod-dva.jpeg", "vikendica-dva.jpg"));
			cas1.setMaxBrojOsoba(3);
//			cas1.setSlobodniTermini();
			cas1.setPravilaPonasanja("Poslusnost");
			cas1.setOpremaUzRezervaciju("Nista");
			cas1.setCenovnikInfo("cenovnik2");
			cas1.setUsloviOtkaza("Nema uslova");
			cas1.setKratkaBiografijaInstruktora("Instruktor Milos, avanturista.");
			cas1.setZbirOcena(0);
			cas1.setUkupnoOcena(0);
			casRepository.saveAndFlush(cas1);

			List<Entitet> entitets = new ArrayList<>();
			entitets.add(brod);
			User user = new User();
			user.setUsername("asd@asd.com");
			user.setPassword("pass");
			user.setAddress("Tolstojeva 5");
			user.setIme("Marko");
			user.setPrezime("Markic");
			user.setGrad("Novi Sad");
			user.setDrzava("Srbija");
			user.setPhone("0644444444");
			user.setActivation(null);
			user.setRole(Role.ROLE_VLASNIK_BRODA);
			user.setEntiteti(entitets);
			user.setPenali(2);

			List<Entitet> entitets1 = new ArrayList<>();
			entitets1.add(cas);
			User user1 = new User();
			user1.setUsername("asd1@asd.com");
			user1.setPassword("pass1");
			user1.setAddress("Bulevar Revolucije 12");
			user1.setIme("Irena");
			user1.setPrezime("Simic");
			user1.setGrad("Beograd");
			user1.setDrzava("Srbija");
			user1.setPhone("0644447774");
			user1.setActivation(null);
			user1.setRole(Role.ROLE_KLIJENT);
			user1.setEntiteti(entitets1);
			user1.setPenali(0);


			userRepository.save(user1);

		List<Entitet> entitets2 = new ArrayList<>();
		entitets2.add(brod);
		User user2 = new User();
		user2.setUsername("asd2@asd.com");
		user2.setPassword("pass2");
		user2.setAddress("Bulevar Nikole Tesle 123");
		user2.setIme("Milos");
		user2.setPrezime("Dugic");
		user2.setGrad("Nis");
		user2.setDrzava("Srbija");
		user2.setPhone("06222247774");
		user2.setActivation(null);
		user2.setRole(Role.ROLE_INSTRUKTOR_PECANJA);
		user2.setEntiteti(entitets2);
		user2.setPenali(0);


		userRepository.save(user2);

			List<Entitet> entitets3 = new ArrayList<>();
			entitets3.add(vikendica1);
			User user3 = new User();
			user3.setUsername("asd4@asd.com");
			user3.setPassword("pass4");
			user3.setAddress("Bulevar Nikole Tesle 123");
			user3.setIme("Marija");
			user3.setPrezime("Dugic");
			user3.setGrad("Nis");
			user3.setDrzava("Srbija");
			user3.setPhone("06222247774");
			user3.setActivation(null);
			user3.setRole(Role.ROLE_VLASNIK_VIKENDICE);
			user3.setEntiteti(entitets3);
			user3.setPenali(0);


			userRepository.save(user3);

			List<Entitet> entitets4 = new ArrayList<>();
			entitets4.add(vikendica1);
			User user4 = new User();
			user4.setUsername("asd3@asd.com");
			user4.setPassword("pass3");
			user4.setAddress("Danila Kisa 3");
			user4.setIme("Vladimir");
			user4.setPrezime("Murina");
			user4.setGrad("Nis");
			user4.setDrzava("Srbija");
			user4.setPhone("06222247774");
			user4.setActivation(null);
			user4.setRole(Role.ROLE_VLASNIK_VIKENDICE);
			user4.setEntiteti(entitets4);
			user4.setPenali(1);


			userRepository.save(user4);


			List<Entitet> entitets5 = new ArrayList<>();
			entitets5.add(cas1);
			User user5 = new User();
			user5.setUsername("asd4@asd.com");
			user5.setPassword("pass4");
			user5.setAddress("Jovana DUcica 3");
			user5.setIme("Igor");
			user5.setPrezime("Ivic");
			user5.setGrad("Trebinje");
			user5.setDrzava("Bosna");
			user5.setPhone("069947074");
			user5.setActivation(null);
			user5.setRole(Role.ROLE_INSTRUKTOR_PECANJA);
			user5.setEntiteti(entitets5);
			user5.setPenali(2);


			userRepository.save(user5);


			List<Entitet> entitets6 = new ArrayList<>();
			entitets6.add(brod1);
			User user6 = new User();
			user6.setUsername("asd6@asd.com");
			user6.setPassword("pass6");
			user6.setAddress("Turgenjeva 665");
			user6.setIme("Djuko");
			user6.setPrezime("Djukanovic");
			user6.setGrad("Tivat");
			user6.setDrzava("Crna Gora");
			user6.setPhone("062222222");
			user6.setActivation(null);
			user6.setRole(Role.ROLE_VLASNIK_BRODA);
			user6.setEntiteti(entitets6);
			user6.setPenali(0);



			List<Entitet> entitets7 = new ArrayList<>();
			entitets7.add(cas);
			User user7 = new User();
			user7.setUsername("asd7@asd.com");
			user7.setPassword("pass7");
			user7.setAddress("Bulevar kralja Aleksandra 11");
			user7.setIme("Olga");
			user7.setPrezime("Danilovic");
			user7.setGrad("Beograd");
			user7.setDrzava("Srbija");
			user7.setPhone("06000202");
			user7.setActivation(null);
			user7.setRole(Role.ROLE_KLIJENT);
			user7.setEntiteti(entitets7);
			user7.setPenali(1);


			userRepository.save(user7);


			List<Entitet> entitets8 = new ArrayList<>();
			entitets8.add(cas);
			User user8 = new User();
			user8.setUsername("admin@asd.com");
			user8.setPassword("passa");
			user8.setAddress("Novi Sad BB");
			user8.setIme("Oliver");
			user8.setPrezime("Tanovic");
			user8.setGrad("Novi Sad");
			user8.setDrzava("Srbija");
			user8.setPhone("0611110202");
			user8.setActivation(null);
			user8.setRole(Role.ROLE_ADMIN);
			user8.setEntiteti(entitets8);
			user8.setPenali(1);


			userRepository.save(user8);



			Akcija akcija = new Akcija();
			akcija.setCena(200);
			akcija.setDatumOd(new Date());
			akcija.setDatumDo(new Date());
			akcija.setEntitet(cas);
			akcija.setDodatneUsluge("pecanje,voznja brodom");
			akcija.setPocela(false);

			akcijaRepository.saveAndFlush(akcija);

			Akcija akcija1 = new Akcija();
			akcija1.setCena(1000);
			akcija1.setDatumOd(new Date());
			akcija1.setDatumDo(new Date());
			akcija1.setEntitet(vikendica);
			akcija1.setDodatneUsluge("voznja brodom");
			akcija1.setPocela(false);

			akcijaRepository.saveAndFlush(akcija1);

			Akcija akcija2 = new Akcija();
			akcija2.setCena(500);
			akcija2.setDatumOd(new Date());
			akcija2.setDatumDo(new Date());
			akcija2.setEntitet(brod1);
			akcija2.setDodatneUsluge("pecanje");
			akcija2.setPocela(false);

			akcijaRepository.saveAndFlush(akcija2);
		};
	}
}

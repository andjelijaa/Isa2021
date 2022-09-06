package com.example.backend;

import com.example.backend.models.*;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.VikendicaRepository;
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

			Brod brod = new Brod();
			Vikendica vikendica = new Vikendica();
			Cas cas = new Cas();

			brod.setNaziv("brod1");
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


			vikendica.setNaziv("vikendica1");
			vikendica.setAdresa("adresa1");
			vikendica.setPromoOpis("PromoOpis1");
			vikendica.setSlike("vikendica-jedan.jpg");
			vikendica.setMaxBrojOsoba(3);
//			vikendica.setSlobodniTermini();
			vikendica.setPravilaPonasanja("pravila1");
			vikendica.setOpremaUzRezervaciju("oprema1");
			vikendica.setCenovnikInfo("cenovnik1");
			vikendica.setUsloviOtkaza("uslovi1");
			vikendica.setBrojKreveta(3);
			vikendica.setBrojSoba(2);
			vikendica.setZbirOcena(0);
			vikendica.setUkupnoOcena(0);
			vikendicaRepository.saveAndFlush(vikendica);

			cas.setNaziv("cas1");
			cas.setAdresa("adresa1");
			cas.setPromoOpis("PromoOpis1");
//			cas.setSlike(Arrays.asList("brod-jedan.jpeg", "vikendica-jedan.jpg"));
			cas.setMaxBrojOsoba(3);
//			cas.setSlobodniTermini();
			cas.setPravilaPonasanja("pravila1");
			cas.setOpremaUzRezervaciju("oprema1");
			cas.setCenovnikInfo("cenovnik1");
			cas.setUsloviOtkaza("uslovi1");
			cas.setKratkaBiografijaInstruktora("askdjoijwadiowj");
			cas.setZbirOcena(0);
			cas.setUkupnoOcena(0);
			casRepository.saveAndFlush(cas);


			List<Entitet> entitets = new ArrayList<>();
			entitets.add(brod);
			User user = new User();
			user.setUsername("asd@asd.com");
			user.setPassword("pass");
			user.setAddress("adresa2");
			user.setIme("ime1");
			user.setPrezime("prezime1");
			user.setGrad("gradojevic");
			user.setDrzava("drzava1");
			user.setPhone("0644444444");
			user.setActivation(null);
			user.setRole(Role.ROLE_VLASNIK_BRODA);
			user.setEntiteti(entitets);
			user.setPenali(2);


			userRepository.save(user);
		};
	}
}

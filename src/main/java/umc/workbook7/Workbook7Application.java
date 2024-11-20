package umc.workbook7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Workbook7Application {

	public static void main(String[] args) {
		SpringApplication.run(Workbook7Application.class, args);
		System.out.println("[Initiate UMC 7th Workbook_Wayne]");
	}

}

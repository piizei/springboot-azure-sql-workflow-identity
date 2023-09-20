package demo.mssql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("demo.mssql.db")
@EntityScan("demo.mssql.db")
public class MssqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(MssqlApplication.class, args);
	}
}

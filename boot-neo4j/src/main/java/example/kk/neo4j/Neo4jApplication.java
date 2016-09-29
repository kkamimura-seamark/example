package example.kk.neo4j;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableNeo4jRepositories
@EnableTransactionManagement
public class Neo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jApplication.class, args);
	}
	@Bean
	CommandLineRunner demo(PersonRepository repo){
		return args -> {
			Person roki = new Person("roki");
			Person muto = new Person("muto");
			Person lee = new Person("lee");
			
			List<Person> team = Arrays.asList(roki,muto,lee);
			
			log.info("Before aaa ....");
			
			team.forEach(p -> log.info("\t" + p.toString()) );
			
			repo.save(roki);
			repo.save(muto);
			repo.save(lee);
			
			roki = repo.findByName("roki");
			roki.worksWith(muto);
			roki.worksWith(lee);
			repo.save(roki);
			
			muto = repo.findByName("muto");
			muto.worksWith(lee);
			repo.save(muto);
			
			team.forEach(p->{
				log.info("\t" + repo.findByName(p.getName()).toString());
			});
			
		};
	}
}

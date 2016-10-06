package example.kk;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import example.kk.data.Id;
import example.kk.data.football.FootballCompetition;
import example.kk.data.football.FootballCompetitionType;
import example.kk.data.football.FootballPlayer;
import example.kk.data.football.FootballPosition;
import example.kk.data.football.FootballTeam;
import example.kk.data.football.Nation;
import example.kk.neo4j.Person;
import example.kk.neo4j.PersonRepository;
import example.kk.neo4j.common.Neo4jNodeRepository;
import example.kk.neo4j.common.Neo4jRelationNode;
import example.kk.neo4j.common.Neo4jRelationNodeRepository;
import example.kk.neo4j.relation.Player;
import example.kk.neo4j.relation.PlayerRepository;
import example.kk.neo4j.relation.Team;
import example.kk.neo4j.relation.TeamPlayer;
import example.kk.neo4j.relation.TeamPlayerRepository;
import example.kk.neo4j.relation.TeamRepository;
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
	@Bean
	CommandLineRunner demoRelationship(TeamRepository team,PlayerRepository player ,TeamPlayerRepository tp ){
		return (args)->{
			log.info("-- start demoRelationship ---");
			
			Team urawa = new Team("浦和レッズ", "浦和");
			team.save(urawa);
			
			Player roki = new Player("興梠","FW");
			Player muto = new Player("武藤","FW");
			Player nishi= new Player("西川","GK");
			Player koma = new Player("駒井","MF");
			Player seki = new Player("関根","MF");
			player.save(Arrays.asList(roki,muto,nishi,koma,seki));
			

			tp.save(
					Arrays.asList(
							new TeamPlayer("", urawa, roki)
							,new TeamPlayer("", urawa, muto)
							,new TeamPlayer("", urawa, nishi)
							,new TeamPlayer("", urawa, koma)
							,new TeamPlayer("", urawa, seki)
					));
			
			log.info("-- end demoRelationship ---");
		};
	}

	@Bean
	CommandLineRunner footballDemo(Neo4jNodeRepository nodeRepo,Neo4jRelationNodeRepository relRepo){
		return (args)->{
			Nation japan = new Nation(new Id("nation01"), "日本");
			FootballCompetition jleague = new FootballCompetition(new Id("competi01"), "Jリーグ",FootballCompetitionType.League, japan);
			nodeRepo.save(jleague);
			
			
			FootballTeam urawa = new FootballTeam(new Id("team01"),"浦和レッズ");
			FootballTeam kasima= new FootballTeam(new Id("team02"),"鹿島アントラーズ");
			FootballTeam fctokyo=new FootballTeam(new Id("team03"),"FC東京");
			nodeRepo.save(Arrays.asList(urawa,kasima,fctokyo));
			
			relRepo.save(Arrays.asList(
					new Neo4jRelationNode(jleague, urawa)
					,new Neo4jRelationNode(jleague, kasima)
					,new Neo4jRelationNode(jleague, fctokyo)
					));
			
			//
			FootballPlayer abe = new FootballPlayer(new Id("p001"), "あべちゃん");
			FootballPlayer maki= new FootballPlayer(new Id("p002"), "まきの");
			FootballPlayer mori= new FootballPlayer(new Id("p003"), "もりわき");
			FootballPlayer endo= new FootballPlayer(new Id("p004"), "わたる");
			nodeRepo.save(Arrays.asList(abe,maki,mori,endo));
			relRepo.save(Arrays.asList(
					new Neo4jRelationNode(urawa, abe).setRelName("所属選手")
					,new Neo4jRelationNode(urawa, maki).setRelName("所属選手")
					,new Neo4jRelationNode(urawa, mori).setRelName("所属選手")
					,new Neo4jRelationNode(urawa, endo).setRelName("所属選手")
					));
			
			FootballPosition fw = new FootballPosition(new Id("pos01"), "FW");
			FootballPosition mf = new FootballPosition(new Id("pos02"), "MF");
			FootballPosition df = new FootballPosition(new Id("pos03"), "DF");
			FootballPosition gk = new FootballPosition(new Id("pos04"), "GK");
			nodeRepo.save(Arrays.asList(fw,mf,df,gk));
			
			
			
		};
	}

}

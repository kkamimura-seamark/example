package example.kk.neo4j.relation;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@NodeEntity
public class Team {

	@GraphId
	private Long id;
	
	private String name;
	
	private String location;

	public Team(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	
}

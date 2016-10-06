package example.kk.neo4j.relation;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@NodeEntity
public class Player {

	@GraphId
	private Long id;
	
	private String name;

	private String position;

	public Player(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}
	
	
}

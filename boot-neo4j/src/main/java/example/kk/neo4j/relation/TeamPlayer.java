package example.kk.neo4j.relation;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@RelationshipEntity(type="TeamPlayer")
public class TeamPlayer {

	@GraphId
	private Long relationshipId;
	@Property
	private String title;
	@StartNode
	private Team team;
	@EndNode
	private Player player;
	
	public TeamPlayer(String title, Team team, Player player) {
		super();
		this.title = title;
		this.team = team;
		this.player = player;
	}
	
	
}

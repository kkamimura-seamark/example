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
@RelationshipEntity(type="GenRelation")
public class GenericRelation {
	@GraphId
	private Long relationshipId;

	@Property
	private String name;

	@StartNode
	private Object startNode;
	@EndNode
	private Object endNode;
	public GenericRelation(String name, Object startNode, Object endNode) {
		super();
		this.name = name;
		this.startNode = startNode;
		this.endNode = endNode;
	}
	
}

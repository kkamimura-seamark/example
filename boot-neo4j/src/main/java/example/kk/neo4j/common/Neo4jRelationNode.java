package example.kk.neo4j.common;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipEntity(type="generic_relation")
public class Neo4jRelationNode {
	@GraphId
	private Long relationId;
	@Property
	private String relationName;
	
	@Property
	private String startNodeType;
	@Property
	private String endNodeType;
	
	@StartNode
	private Neo4jNode startNode;
	@EndNode
	private Neo4jNode endNode;

	public Neo4jRelationNode(Neo4jNode startNode, Neo4jNode endNode) {
		this(startNode.getClass().getTypeName(),startNode,endNode.getClass().getTypeName(),endNode);
	}
	
	public Neo4jRelationNode(String startNodeType, Neo4jNode startNode, String endNodeType, Neo4jNode endNode) {
		super();
		this.startNodeType = startNodeType;
		this.endNodeType = endNodeType;
		this.startNode = startNode;
		this.endNode = endNode;
	}
	public Neo4jRelationNode setRelName(String name){
		this.relationName = name;
		return this;
	}
}

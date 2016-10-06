package example.kk.neo4j.common;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@NodeEntity
public class Neo4jNode {
	@GraphId
	private Long nodeId;
}

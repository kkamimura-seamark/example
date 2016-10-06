package example.kk.data;

import org.neo4j.ogm.annotation.NodeEntity;

import example.kk.neo4j.common.Neo4jNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NodeEntity
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=true)
public abstract class Entity extends Neo4jNode {
	@NonNull
	private Id identity;
	private String description;
}

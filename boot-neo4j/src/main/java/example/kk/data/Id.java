package example.kk.data;

import example.kk.neo4j.common.Neo4jNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Id extends Neo4jNode {
	@NonNull
	private String value;
}

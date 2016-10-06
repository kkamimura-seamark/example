package example.kk.neo4j.common;

import org.springframework.data.neo4j.repository.GraphRepository;

import example.kk.data.Entity;

public interface Neo4jNodeRepository extends GraphRepository<Entity> {
	
}

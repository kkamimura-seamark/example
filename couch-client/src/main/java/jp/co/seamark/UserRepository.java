package jp.co.seamark;

import java.util.List;

import org.springframework.data.couchbase.core.query.Dimensional;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.geo.Box;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {

/*	List<User> findByLastnameAndAgeBetween(String lastName ,int minAge ,int maxAge);
	
	@View(designDocument = "user" ,viewName = "byName")
	List<User> findByLastName(String lastName); 
	
	@Dimensional(designDocument="userGeo" ,spatialViewName="byLocation")
	List<User> findByLocationWithin(Box cityBoundingBox);
*/
}

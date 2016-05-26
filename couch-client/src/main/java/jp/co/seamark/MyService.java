package jp.co.seamark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	private final UserRepository repository;
	
	@Autowired
	public MyService(UserRepository r){
		this.repository = r;
	}
	
	public void doWork(){
		repository.deleteAll();
		
		User u = new User();
		u.setLastName("Jackson");
		u.setLocation(new Point(42.123, 102.1111));
		
		u = repository.save(u);
		
		
		
	}
}

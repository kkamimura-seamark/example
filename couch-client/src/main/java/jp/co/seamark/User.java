package jp.co.seamark;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.geo.Point;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document(expiry=0)
public class User {
	@Id
	private String id = UUID.randomUUID().toString();
	@Field
	private String lastName;
	@Field
	private Point location;
	@Field
	private Map<String, Object> values = new HashMap<>();
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void putValue(String key,Object val){
		values.put(key, val);
	}
	public Object getValue(String key) {
		return values.get(key);
	}
	
}

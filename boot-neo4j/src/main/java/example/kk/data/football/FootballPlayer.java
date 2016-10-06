package example.kk.data.football;

import example.kk.data.Entity;
import example.kk.data.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FootballPlayer extends Entity{
	private String name;

	public FootballPlayer(Id identity, String name) {
		super(identity);
		this.name = name;
	}	
}

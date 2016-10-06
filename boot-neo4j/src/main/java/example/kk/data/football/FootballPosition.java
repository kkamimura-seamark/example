package example.kk.data.football;

import example.kk.data.Entity;
import example.kk.data.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FootballPosition extends Entity {
	private String name;

	public FootballPosition(Id identity, String name) {
		super(identity);
		this.name = name;
	}

	
}

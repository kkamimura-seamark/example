package example.kk.data.football;

import example.kk.data.Entity;
import example.kk.data.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper=true)
public class FootballTeam extends Entity {
	@NonNull
	private String name;

	public FootballTeam(Id identity, String name) {
		super(identity);
		this.name = name;
	}

}

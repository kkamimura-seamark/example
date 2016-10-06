package example.kk.data.football;

import example.kk.data.Entity;
import example.kk.data.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FootballCompetition extends Entity {
	private String name;
	private FootballCompetitionType type;
	private Nation nation;
	
	public FootballCompetition(Id identity, String name, FootballCompetitionType type, Nation nation) {
		super(identity);
		this.name = name;
		this.type = type;
		this.nation = nation;
	}
}

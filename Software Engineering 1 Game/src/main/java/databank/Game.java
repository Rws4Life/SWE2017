package databank;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Game")
public class Game {
	/*GameID integer NOT NULL,
Beginning time,
Ending time,
RoundNumber integer*/
	@Id
	@Column(name="GameID")
	int gameID;
	
	@Column(name="RoundNumber")
	int roundNumber;
}

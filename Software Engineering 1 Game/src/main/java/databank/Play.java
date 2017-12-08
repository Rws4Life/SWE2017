package databank;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/*@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "GameID", nullable = false)
public int getGameID() {
	return this.gameID;
}*/


@Entity
@Table(name="Play")
public class Play implements Serializable{
	
	@Id
	@ManyToOne()
	@JoinColumn(name = "GameID")
	public Game game;
	
	@ManyToOne()
	@JoinColumn(name = "PlayerID")
	public Player player1;
	
	
	public Player player2;

}

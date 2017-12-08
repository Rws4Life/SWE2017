package databank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(
			name = "get_game",
			query = "from Game where gameID = :name"
	)
})

@Entity
@Table(name="Game")
public class Game {
	/*GameID integer NOT NULL,
Beginning time,
Ending time,
RoundNumber integer
STRING map*/
	
	/*private Set<ActionList> al = new HashSet<ActionList>(
			0);
	private List<ActionList> actionList = new ArrayList<>();*/
	
	@Id
	@Column(name="GameID")
	int gameID;
	
	@Column(name="RoundNumber")
	int roundNumber;
	
	@Column(name="Map")
	String map;
	
	/*@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	public List<ActionList> getActionList(){
		return this.actionList;
	}*/
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
	public Set<ActionList> getActionList() {
		return this.al;
	}*/

	/*public void setActionList(Set<ActionList> al) {
		this.al = al;
	}*/
	
	Game() {}
	
	Game(int gameID, int roundNumber){
		init(gameID, roundNumber);
	}
	
	private void init(int gameID, int roundNumber) {
		this.gameID = gameID;
		this.roundNumber = roundNumber;
	}
	
	public void setMap(String map) {
		this.map = map;
	}
	
	public String getMap() {
		return map;
	}
	
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public int getGameID() {
		return gameID;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public int getRoundNumber() {
		return roundNumber;
	}
	
	/*public List<ActionList> getActionList() {
		return actionList;
	}*/
}

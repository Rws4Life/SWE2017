package databank;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="ActionList")
public class ActionList {
	/*GameID integer NOT NULL,
	ActionID integer NOT NULL,
	Action char(5), //UP, DOWN, LEFT, RIGHT, STAY*/
	
	private int gameID;
	
	@Id
	@Column(name="ActionID")
	private int actionID;
	
	@Column(name="Action")
	private String action;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GameID", nullable = false)
	public int getGameID() {
		return this.gameID;
	}
	
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	public void setActionID(int actionID) {
		this.actionID = actionID;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	ActionList(){}
	
	ActionList(int gameID, int actionID, String action){
		this.actionID = actionID;
		this.action = action;
	}
	
	public int getActionID() {
		return actionID;
	}
	public String getAction() {
		return action;
	}
	
	
	
}

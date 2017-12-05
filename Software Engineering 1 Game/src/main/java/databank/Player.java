package databank;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Player")
public class Player {
/*PlayerID integer NOT NULL,
Surname char(30),
FirstName char(30),
MatriculationNumber char(9),
StartingCoordinates char(3),*/
	@Id
	@Column(name="PlayerID")
	int playerID;
	
	@Column(name="FirstName")
	String firstName;
	
	@Column(name="SurName")
	String surName;
	
	@Column(name="MatriculationNumber")
	String matriculationNumber;
	
	@Column(name="StartingCoordinates")
	String startingCoordinates;
}

package server;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class NewPlayerRequest {
	String firstName, surName;
	int matriculationNumber;
	
	public String getFirstName() {
		return firstName;
	}
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return surName;
	}
	@XmlElement
	public void setSecondName(String surName) {
		this.surName = surName;
	}
	public int getMatrikelnummer() {
		return matriculationNumber;
	}
	@XmlElement
	public void setMatrikelnummer(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}
	
	
}

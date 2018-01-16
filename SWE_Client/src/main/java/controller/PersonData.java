package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.MapGenerator;

public class PersonData {
	Logger logger = LoggerFactory.getLogger(MapGenerator.class);
	String firstName;
	String famName;
	int matriculation;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getFamName() {
		return famName;
	}
	public void setFamName(String famName) {
		this.famName = famName;
	}
	
	
	public int getMatriculation() {
		return matriculation;
	}
	public void setMatriculation(int matriculation) {
		this.matriculation = matriculation;
	}
	
	
	
	
	
	
	
	
//press button in controller -> refresh model and view
	//enter name, matriculation number -> choose map style (rand gen or premade)
	public void personData() {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		logger.info("Starting process: Get Data from User.");
		//int x= Integer.parseInt(br.readLine());
		
		System.out.println("Please enter your name: ");
		try {
			firstName=br.readLine();
			logger.info("First name input correct.");
			
		} catch (IOException e) {
			logger.info("First name input interrupted. Input: " + firstName);
			e.printStackTrace();
		}
		
		System.out.println("Please enter your family name: ");
		
		try {
			famName=br.readLine();
			logger.info("Family name input correct.");
		} catch (IOException e) {
			logger.info("Family name input interrupted. Input: " + famName);
			e.printStackTrace();
		}
		
		System.out.println("Please enter your matriculation number: ");
		try {
			matriculation = Integer.parseInt(br.readLine());
			logger.info("Matriculation number input correct.");
		} catch (NumberFormatException e) {
			logger.info("Matriculation number input incorrect due to usage of non-number characters. Input: " + matriculation);
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("Matriculation number input interrupted. Input: " + matriculation);
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
}

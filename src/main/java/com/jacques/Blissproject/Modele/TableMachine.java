package com.jacques.Blissproject.Modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jacques.Blissproject.InfoMachine;



public class TableMachine implements Serializable{

	
	private int id;
	
	private String machine;
	
	
	


	public String getMachine() {
		 InfoMachine machine = new InfoMachine();
		String infomach =  machine.getSystemName();
		return infomach;
	}

	
	

	public TableMachine() {
		
	}

	public TableMachine(String machine) {
		super();
		this.id = id;
		this.machine = machine;
		
	}
	
	
	
	
	
	
	
}

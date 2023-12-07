package com.imranmadbar;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 7156526077883281623L;
	
    private int id;
    
    private String name;

    // Example constructor
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
}
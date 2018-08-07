package cn.boz.domain;

import java.util.Vector;

public class User {
	
	private String id;
	private String name;
	private Vector underling=new Vector();;
	private User manager;
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector getUnderling() {
		return underling;
	}
	public void setUnderling(Vector underling) {
		this.underling = underling;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	

	
	
}

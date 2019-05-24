package com.wbn.hr.bean;

public class Staff {

	private int id;
	
	private String name;
	
	private String gender;
	
	private String job;


	public Staff() {
		super();
	}

	public Staff(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", gender=" + gender + ", job=" + job + "]";
	}
	
	
}

package com.Estuate.models;

public class Employees {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String password;
    private String role;
    
    public Employees(int id, String name, String mobile, String email, String address, String password, String role,
			String rating, String feedback) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.password = password;
		this.role = role;
		this.rating = rating;
		this.feedback = feedback;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String rating;
    
    private String feedback;

    public Employees() {}

    public Employees( String name, String email, String rating, String feedback) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.feedback = feedback;
    }

    public Employees(int id, String name, String mobile, String email, String address, String password) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.password = password;
		this.role = role;
	}

	public Employees(String name, String mobile, String email, String address, String password, String role) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.password = password;
		this.role = role;
	}

	

	public Employees(int id, String name, String email, String mobile,String address, String rating,String role) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.rating = rating;
		this.role = role;
	}

	// Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

    
}

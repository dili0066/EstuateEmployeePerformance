package com.Estuate.models;



public class Ratings {
    private int id;
    private int empId;
    private char previousRating; // Single character (A-E)
    private char newRating; // Single character (A-E)
    private String status; // Example: "Pending", "Approved", "Rejected"

    public Ratings() {}

    public Ratings(int id, int empId, char previousRating, char newRating, String status) {
        this.id = id;
        this.empId = empId;
        this.previousRating = previousRating;
        this.newRating = newRating;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public char getPreviousRating() { return previousRating; }
    public void setPreviousRating(char previousRating) { this.previousRating = previousRating; }

    public char getNewRating() { return newRating; }
    public void setNewRating(char newRating) { this.newRating = newRating; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", empId=" + empId +
                ", previousRating=" + previousRating +
                ", newRating=" + newRating +
                ", status='" + status + '\'' +
                '}';
    }
}

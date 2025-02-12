package com.Estuate.models;



public class SuggestedRevision {
    private int id;
    private int empId;
    private char currentRating; // Single character (A-E)
    private char suggestedRating; // Single character (A-E)
    private String status; // Example: "Pending", "Approved", "Rejected"
    private String reason; // Reason for revision request

    public SuggestedRevision() {}

    public SuggestedRevision(int id, int empId, char currentRating, char suggestedRating, String status, String reason) {
        this.id = id;
        this.empId = empId;
        this.currentRating = currentRating;
        this.suggestedRating = suggestedRating;
        this.status = status;
        this.reason = reason;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public char getCurrentRating() { return currentRating; }
    public void setCurrentRating(char currentRating) { this.currentRating = currentRating; }

    public char getSuggestedRating() { return suggestedRating; }
    public void setSuggestedRating(char suggestedRating) { this.suggestedRating = suggestedRating; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    @Override
    public String toString() {
        return "SuggestedRevision{" +
                "id=" + id +
                ", empId=" + empId +
                ", currentRating=" + currentRating +
                ", suggestedRating=" + suggestedRating +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

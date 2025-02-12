package com.Estuate.models;



public class Deviation {
    private int id;
    private String ratingCategory; // Example: "Performance", "Leadership", etc.
    private double standardPercentage; // Standard % for the category
    private double actualPercentage; // Actual % achieved
    private double deviation; // Difference between standard and actual %
    private String suggestedChange; // Suggestions for improvement

    public Deviation() {}

    public Deviation(int id, String ratingCategory, double standardPercentage, double actualPercentage, double deviation, String suggestedChange) {
        this.id = id;
        this.ratingCategory = ratingCategory;
        this.standardPercentage = standardPercentage;
        this.actualPercentage = actualPercentage;
        this.deviation = deviation;
        this.suggestedChange = suggestedChange;
    }

    public Deviation(String ratingCategory, double standardPercentage, double actualPercentage, double deviation,
			String suggestedChange) {
		super();
		this.ratingCategory = ratingCategory;
		this.standardPercentage = standardPercentage;
		this.actualPercentage = actualPercentage;
		this.deviation = deviation;
		this.suggestedChange = suggestedChange;
	}

	// Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRatingCategory() { return ratingCategory; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

    public double getStandardPercentage() { return standardPercentage; }
    public void setStandardPercentage(double standardPercentage) { this.standardPercentage = standardPercentage; }

    public double getActualPercentage() { return actualPercentage; }
    public void setActualPercentage(double actualPercentage) { this.actualPercentage = actualPercentage; }

    public double getDeviation() { return deviation; }
    public void setDeviation(double deviation) { this.deviation = deviation; }

    public String getSuggestedChange() { return suggestedChange; }
    public void setSuggestedChange(String suggestedChange) { this.suggestedChange = suggestedChange; }

    @Override
    public String toString() {
        return "Deviation{" +
                "id=" + id +
                ", ratingCategory='" + ratingCategory + '\'' +
                ", standardPercentage=" + standardPercentage +
                ", actualPercentage=" + actualPercentage +
                ", deviation=" + deviation +
                ", suggestedChange='" + suggestedChange + '\'' +
                '}';
    }
}


package com.company;

public class Parcel {
    private String id;
    private double weight;

    /**
     *
     * @param id Id of the package
     * @param weight Weight of the package in pounds
     */
    public Parcel(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    /**
     *
     * @param id Id of the package
     */
    public Parcel(String id) {
        this(id, 5);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("ID: " + this.id + ", " + "Weight: " + this.weight);
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Parcel) {
            Parcel otherParcel = (Parcel) other;
            return ((this.id == otherParcel.id) && (this.weight == otherParcel.weight));
        }

        return false;
    }
}

package com.company;

public class Computer {
    private String brand;
    private String memory;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }


    Computer() {
        this.brand = "iMac";
        this.memory = "512GB";
    }

    Computer(String inputBrand, String inputMemory) {
        this.brand = inputBrand;
        this.memory = inputMemory;
    }

    @Override
    public String toString() {
        return String.format("Brand: " + this.brand + ", " + "Memory: " + this.memory);
    }

    public boolean equals(Computer inputComputer) {
        return this.brand.equals(inputComputer.brand) && this.memory.equals(inputComputer.memory);
    }
}

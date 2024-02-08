package edu.iu.anderblm.c322spring2024homework2.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Guitar {
    private String serialNumber;
    private double price;
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    // Add a default constructor for Spring
    public Guitar(String builder, String backWood) {
        // Implement constructor if needed
    }

    public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    // Getters and setters as needed

    public void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("guitars_database.txt", true))) {
            writer.println(serialNumber + "," + price + "," + builder.toString() + "," + model + "," + type.toString() + "," + backWood.toString() + "," + topWood.toString());
            System.out.println("Guitar written to guitars_database.txt.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


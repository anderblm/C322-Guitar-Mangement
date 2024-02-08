package edu.iu.anderblm.c322spring2024homework2.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Guitar {
    private String serialNumber;
    private double price;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;

    // Add a default constructor for Spring
    public Guitar() {
    }

    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
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

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("guitars_database.txt", true))) {
            writer.println(serialNumber + "," + price + "," + builder + "," + model + "," + type + "," + backWood + "," + topWood);
            System.out.println("Guitar written to guitars_database.txt.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


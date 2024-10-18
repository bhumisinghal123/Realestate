package com.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// Property class
class Property {
    private String id;
    private String address;
    private String type;
    private double price;

    public Property(String id, String address, String type, double price) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.price = price;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

// RealEstateManagementSystem class
public class RealEstateManagementSystem extends Frame {
    private List<Property> properties;
    private TextField idField, addressField, typeField, priceField;
    private TextArea outputArea;

    public RealEstateManagementSystem() {
        properties = new ArrayList<>();

        // Create UI components
        Label idLabel = new Label("Property ID:");
        idField = new TextField(10);
        idLabel.setFont(new Font("Arial",Font.BOLD,20));

        Label addressLabel = new Label("Property Address:");
        addressField = new TextField(20);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));

        Label typeLabel = new Label("Property Type:");
        typeField = new TextField(10);
        typeLabel.setFont(new Font("Arial",Font.BOLD,20));

        Label priceLabel = new Label("Property Price:");
        priceField = new TextField(10);
        priceLabel.setFont(new Font("Arial",Font.BOLD,20));

        Button addButton = new Button("Add Property");
        addButton.addActionListener(new AddButtonListener());
        addButton.setFont(new Font("Arial",Font.BOLD,20));

        Button removeButton = new Button("Remove Property");
        removeButton.addActionListener(new RemoveButtonListener());
        removeButton.setFont(new Font("Arial",Font.BOLD,20));

        Button listButton = new Button("List Properties");
        listButton.addActionListener(new ListButtonListener());
        listButton.setFont(new Font("Arial",Font.BOLD,20));
        outputArea = new TextArea(10, 30);

        // Set the layout to GridLayout
        setLayout(new GridLayout(6, 2)); // 6 rows, 2 columns

        // Add UI components sequentially
        add(idLabel);
        add(idField);

        add(addressLabel);
        add(addressField);

        add(typeLabel);
        add(typeField);

        add(priceLabel);
        add(priceField);

        add(addButton);
        add(removeButton);

        add(listButton);
        add(outputArea);

        // Set up the frame
        setTitle("Real Estate Management System");
        setSize(400, 300);
        setVisible(true);
    }

    // Inner class for Add button listener
    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();
            String address = addressField.getText();
            String type = typeField.getText();
            double price = Double.parseDouble(priceField.getText());

            Property property = new Property(id, address, type, price);
            properties.add(property);

            outputArea.append("Property added: " + id + "\n");
        }
    }

    // Inner class for Remove button listener
    private class RemoveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();

            properties.removeIf(property -> property.getId().equals(id));

            outputArea.append("Property removed: " + id + "\n");
        }
    }

    // Inner class for List button listener
    private class ListButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputArea.setText("");

            for (Property property : properties) {
                outputArea.append("ID: " + property.getId() + "\n");
                outputArea.append("Address: " + property.getAddress() + "\n");
                outputArea.append("Type: " + property.getType() + "\n");
                outputArea.append("Price: " + property.getPrice() + "\n\n");
            }
        }
    }

    // Main method

}

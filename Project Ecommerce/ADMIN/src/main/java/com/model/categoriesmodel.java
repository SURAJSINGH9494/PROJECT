package com.model;

public class categoriesmodel {

    private int categoriesId;
    private String name;
    private String description;
    private byte[] label; // For storing the image as a binary large object (BLOB)
    private String base64Image; // To store the image in base64 encoding

    // Getters and Setters
    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLabel() {
        return label;
    }

    public void setLabel(byte[] label) {
        this.label = label;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}

package kh.edu.ferupp.mad.madproject.Models;

import com.google.gson.annotations.SerializedName;

public class Categories {
    private int idCategory;
    @SerializedName("description")
    private String description;
    @SerializedName("imageUrl")
    private String imageUrl;

    // Getter for categories_id
    public int getCategoriesId() {
        return idCategory;
    }

    // Setter for categories_id
    public void setCategoriesId(int idCategory) {
        this.idCategory = idCategory;
    }

    // Getter for title
    public String getTitle() {
        return description;
    }

    // Setter for title
    public void setTitle(String description) {
        this.description = description;
    }

    // Getter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    // Setter for imageUrl
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

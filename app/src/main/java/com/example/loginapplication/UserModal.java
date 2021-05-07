package com.example.loginapplication;

public class UserModal {

    // variables for our first name,
    // last name, email and avatar
    private String recipe_name;
    private String cook_time;
    private String serving;
    private String ingredients;
    private String steps;
    private String web_source;
    private String diet_tags;
    private String image_URL;

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getWeb_source() {
        return web_source;
    }

    public void setWeb_source(String web_source) {
        this.web_source = web_source;
    }

    public String getDiet_tags() {
        return diet_tags;
    }

    public void setDiet_tags(String diet_tags) {
        this.diet_tags = diet_tags;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public UserModal(String recipe_name, String cook_time, String serving, String ingredients,
                        String steps, String web_source, String diet_tags, String image_URL) {
        this.recipe_name = recipe_name;
        this.cook_time = cook_time;
        this.serving = serving;
        this.ingredients = ingredients;
        this.steps = steps;
        this.web_source = web_source;
        this.diet_tags = diet_tags;
        this.image_URL = image_URL;

    }
}

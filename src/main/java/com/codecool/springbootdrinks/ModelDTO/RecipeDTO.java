package com.codecool.springbootdrinks.ModelDTO;

import com.codecool.springbootdrinks.Model.Type;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    Long id;
    String name;
    String description;
    List<Long> liquorList = new ArrayList<>();
    Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getLiquorList() {
        return liquorList;
    }

    public void setLiquorList(List<Long> liquorList) {
        this.liquorList = liquorList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

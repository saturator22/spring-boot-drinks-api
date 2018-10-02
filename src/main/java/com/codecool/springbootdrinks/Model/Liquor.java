package com.codecool.springbootdrinks.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="liquors")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "liquorId")
public class Liquor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "liquor_id")
    private long liquorId;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "liquors_receipes",
            joinColumns = { @JoinColumn(name = "liquor_id") },
            inverseJoinColumns = { @JoinColumn(name = "recipe_id") })
    private List<Recipe> recipeList = new ArrayList<>();

    protected Liquor() {}

    public Liquor(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public void setLiquorId(long liquorId) {
        this.liquorId = liquorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getLiquorId() {
        return liquorId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public String toString() {
        return "Liquor{" +
                "liquorId=" + liquorId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

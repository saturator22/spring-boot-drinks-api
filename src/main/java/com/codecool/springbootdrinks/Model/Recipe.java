package com.codecool.springbootdrinks.Model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    long id;

    @Column
    String name;
    @Column(columnDefinition = "text default ''")
    String description;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "recipeList")
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonBackReference(value = "liquor-recipe")
    List<Liquor> liquorList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Type type;

    protected Recipe(){}

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Liquor> getLiquorList() {
        return liquorList;
    }

    public void setLiquorList(List<Liquor> liquorList) {
        this.liquorList = liquorList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

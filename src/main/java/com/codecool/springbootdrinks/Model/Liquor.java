package com.codecool.springbootdrinksapi.Model;

import javax.persistence.*;

@Entity
@Table(name="liquors")
public class Liquor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "liquor_id")
    private long liquorId;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;

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

    @Override
    public String toString() {
        return "Liquor{" +
                "liquorId=" + liquorId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

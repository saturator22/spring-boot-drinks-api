package com.codecool.springbootdrinks.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    long id;

    @Column
    String name;
    @Column
    String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "recipeList")
    List<Liquor> liquorList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Type type;
}

package com.codecool.springbootdrinks.Model;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    int id;

    @Column
    @ManyToMany
    int[] liquor_ids;
}

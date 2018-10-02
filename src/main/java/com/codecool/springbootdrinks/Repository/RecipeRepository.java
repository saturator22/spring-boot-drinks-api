package com.codecool.springbootdrinks.Repository;

import com.codecool.springbootdrinks.Model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}

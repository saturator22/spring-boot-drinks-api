package com.codecool.springbootdrinks.Repository;

import com.codecool.springbootdrinks.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAll();
    Recipe findRecipeById(Long id);
}

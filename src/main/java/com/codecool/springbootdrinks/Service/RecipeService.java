package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findByRecipeId(Long recipeId) {
        return recipeRepository.findRecipeById(recipeId);
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}

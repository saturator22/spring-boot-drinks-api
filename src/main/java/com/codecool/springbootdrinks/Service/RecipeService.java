package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Recipe editRecipe(Long recipeId, Recipe requestedRecipe) {
        Recipe loadedRecipe = recipeRepository.findRecipeById(recipeId);
        loadedRecipe.setDescription(requestedRecipe.getDescription());
        loadedRecipe.setName(requestedRecipe.getName());

        return recipeRepository.save(loadedRecipe);
    }

    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipeRepository.delete(recipe);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new IllegalArgumentException("Question not found with id " + id));
    }
}

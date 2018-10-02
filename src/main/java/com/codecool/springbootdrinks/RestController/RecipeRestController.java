package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RecipeRestController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.findByRecipeId(id);
    }

    @PostMapping(value = "/recipes", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}

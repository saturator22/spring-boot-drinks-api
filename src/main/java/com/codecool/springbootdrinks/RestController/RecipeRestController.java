package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.ExceptionHandler.ResourceNotFoundException;
import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.ModelDTO.RecipeDTO;
import com.codecool.springbootdrinks.Service.RecipeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RecipeRestController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() throws ResourceNotFoundException {
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable Long id) throws ResourceNotFoundException {
        return recipeService.findByRecipeId(id);
    }

    @PostMapping(value = "/recipes")
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PutMapping(value = "/recipes/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) throws ResourceNotFoundException {
        return recipeService.editRecipe(id, recipeDTO);
    }

    @DeleteMapping(value = "/recipes/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        return recipeService.deleteRecipe(id);
    }
}

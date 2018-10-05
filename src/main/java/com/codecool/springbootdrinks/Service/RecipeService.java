package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.DTOMapper.Mapper;
import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.ModelDTO.RecipeDTO;
import com.codecool.springbootdrinks.Repository.LiquorRepository;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import com.codecool.springbootdrinks.ExceptionHandler.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private static final Logger log4j = LogManager.getLogger(RecipeService.class);
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private Mapper mapper;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() throws ResourceNotFoundException {
        log4j.info("Get ALL recipes");
        List<Recipe> allRecipes = recipeRepository.findAll();
        if (allRecipes.size() == 0) {
            throw new ResourceNotFoundException();
        } else {
            return allRecipes;
        }
    }

    public Recipe findByRecipeId(Long recipeId) throws ResourceNotFoundException {
        log4j.info("Get recipe: id:" + recipeId);
        Recipe recipe = recipeRepository.findRecipeById(recipeId);

        if (recipe == null) {
            throw new ResourceNotFoundException(recipeId);

        } else {
            return recipe;
        }
    }

    public Recipe addRecipe(Recipe recipe) {
        log4j.info("Add recipe id:" + recipe.getId());
        return recipeRepository.save(recipe);
    }

    @Transactional
    public Recipe editRecipe(Long recipeId, RecipeDTO requestedRecipeDTO) throws ResourceNotFoundException {
        log4j.info("Edit recipe id:" + recipeId);

        if (recipeRepository.findRecipeById(recipeId) != null) {
            return mapper.mapRecipeDTOtoRecipe(recipeId, requestedRecipeDTO);
        } else {
            throw new ResourceNotFoundException(recipeId);
        }

    }

    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        log4j.info("Delete recipe id:" + id);
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipeRepository.delete(recipe);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}

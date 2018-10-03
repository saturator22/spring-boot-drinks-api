package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.ModelDTO.RecipeDTO;
import com.codecool.springbootdrinks.Repository.LiquorRepository;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private LiquorRepository liquorRepository;

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

    @Transactional
    public Recipe editRecipe(Long recipeId, RecipeDTO requestedRecipeDTO) {
        Recipe loadedRecipe = recipeRepository.findRecipeById(recipeId);
        loadedRecipe.setDescription(requestedRecipeDTO.getDescription());
        loadedRecipe.setName(requestedRecipeDTO.getName());

        List<Liquor> liquors = loadedRecipe.getLiquorList();

        for (Liquor liquor : liquors) {
            if (!requestedRecipeDTO.getLiquorList().contains(liquor.getLiquorId())) {
                recipeRepository.deleteLiquorFromRecipe(liquor.getLiquorId(), recipeId);
            }
        }
//        liquors.clear();
        for (Long liquorId : requestedRecipeDTO.getLiquorList()) {
            Liquor liquor = liquorRepository.findLiquorByLiquorId(liquorId);
            if(!liquors.contains(liquor)) {
                liquors.add(liquor);

                recipeRepository.addLiquorToRecipe(liquorId, recipeId);

                liquorRepository.save(liquor);
            }
        }

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

package com.codecool.springbootdrinks.DTOMapper;

import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.ModelDTO.RecipeDTO;
import com.codecool.springbootdrinks.Repository.LiquorRepository;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    LiquorRepository liquorRepository;

    public Recipe mapRecipeDTOtoRecipe(Long recipeId, RecipeDTO requestedRecipeDTO) {
        Recipe loadedRecipe = recipeRepository.findRecipeById(recipeId);
        loadedRecipe.setDescription(requestedRecipeDTO.getDescription());
        loadedRecipe.setName(requestedRecipeDTO.getName());

        List<Liquor> liquors = loadedRecipe.getLiquorList();

        for (Liquor liquor : liquors) {
            if (!requestedRecipeDTO.getLiquorList().contains(liquor.getLiquorId())) {
                recipeRepository.deleteLiquorFromRecipe(liquor.getLiquorId(), recipeId);
            }
        }

        for (Long liquorId : requestedRecipeDTO.getLiquorList()) {
            Liquor liquor = liquorRepository.findLiquorByLiquorIdAndArchivedFalse(liquorId);
            if(!liquors.contains(liquor)) {
                liquors.add(liquor);

                recipeRepository.addLiquorToRecipe(liquorId, recipeId);

                liquorRepository.save(liquor);
            }
        }
        return recipeRepository.save(loadedRecipe);
    }
}

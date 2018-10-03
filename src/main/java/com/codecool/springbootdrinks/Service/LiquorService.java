package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Model.Recipe;
import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.LiquorRepository;
import com.codecool.springbootdrinks.Repository.RecipeRepository;
import com.codecool.springbootdrinks.Repository.TypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiquorService {
    @Autowired
    LiquorRepository liquorRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    RecipeRepository recipeRepository;

    private static final Logger log4j = LogManager.getLogger(LiquorService.class);

    public LiquorService(LiquorRepository liquorRepository, RecipeRepository recipeRepository) {
        this.liquorRepository = liquorRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Liquor> getAllLiquors() {
        log4j.info("Get ALL Liquors");
        return liquorRepository.findAll();
    }

    public Liquor getLiquorById(Long id) {
        return liquorRepository.findLiquorByLiquorId(id);
    }

    public Liquor createLiquor(Liquor liquor) {
        return liquorRepository.save(liquor);
    }

    public ResponseEntity<?> deleteLiquor(Long liquorId) {
        return liquorRepository.findById(liquorId)
                .map(liquor -> {
                    liquorRepository.delete(liquor);
                return ResponseEntity.ok().build();})
                .orElseThrow(() -> new IllegalArgumentException("There is no resource like that"));
    }

    public Liquor updateLiquor(Long liquorId, Liquor liquorRequest) {
        return liquorRepository.findById(liquorId)
                .map(liquor -> {
                    liquor.setCategory(liquorRequest.getCategory());
                    liquor.setName(liquorRequest.getName());
                    liquor.setRecipeList(liquorRequest.getRecipeList());
                    return liquorRepository.save(liquor);
                }).orElseThrow(() -> new IllegalArgumentException("There is no resource like that"));
    }

//    public void addData() {
//        Liquor liquor = new Liquor("Whisky", "Johnny Walker");
//        Liquor liquor2 = new Liquor("Whisky", "Ballantines");
//        Liquor liquor1 = new Liquor("Martini", "Bianco");
//        Recipe recipe = new Recipe("Whisky Sour", "Whisky 50 ml,\nEggWhite,\nLemon Juice");
//        Recipe recipe1 = new Recipe("Vodka Martini", "Martini Bianco 80 ml\nVodka 50 ml\nLemon or Olive");
//        Type type = new Type("Short");
//        Type type1 = new Type("Tini");
//
//        typeRepository.save(type);
//        typeRepository.save(type1);
//
//        liquor.getRecipeList().add(recipe);
//        liquor2.getRecipeList().add(recipe);
//        liquor1.getRecipeList().add(recipe1);
//        recipe.getLiquorList().add(liquor);
//        recipe.getLiquorList().add(liquor2);
//        recipe1.getLiquorList().add(liquor1);
//        recipe.setType(type);
//        recipe1.setType(type1);
//
//        liquorRepository.save(liquor);
//        liquorRepository.save(liquor1);
//        liquorRepository.save(liquor2);
//    }
}

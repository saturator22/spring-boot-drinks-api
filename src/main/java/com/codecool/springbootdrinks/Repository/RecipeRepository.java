package com.codecool.springbootdrinks.Repository;

import com.codecool.springbootdrinks.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAll();
    Recipe findRecipeById(Long id);

    @Modifying
    @Query(value = "DELETE FROM liquors_receipes WHERE liquor_id = :liq_id AND recipe_id = :rec_id", nativeQuery = true)
    void deleteLiquorFromRecipe(@Param("liq_id")Long liq_id, @Param("rec_id")Long rec_id);

    @Modifying
    @Query(value = "INSERT INTO liquors_receipes (liquor_id, recipe_id) VALUES (:liq_id, :rec_id);", nativeQuery = true)
    void addLiquorToRecipe(@Param("liq_id")Long liq_id, @Param("rec_id")Long rec_id);
}

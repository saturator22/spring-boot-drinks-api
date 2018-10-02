package com.codecool.springbootdrinks.Repository;

import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiquorRepository extends JpaRepository<Liquor, Long> {
    List<Liquor> findLiquorsByRecipeListContains(Recipe recipe);
    Liquor findLiquorByLiquorId(Long liquorId);
}

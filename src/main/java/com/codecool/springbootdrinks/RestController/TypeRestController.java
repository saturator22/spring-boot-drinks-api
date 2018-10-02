package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeRestController {
    @Autowired
    TypeRepository typeRepository;

    public TypeRestController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/types")
    public List<Type> getRecipes() {
        return typeRepository.findAll();
    }
}

package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.TypeRepository;
import com.codecool.springbootdrinks.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TypeRestController {
    @Autowired
    TypeService typeService;

    public TypeRestController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public List<Type> getRecipes() {
        return typeService.findAll();
    }

    @GetMapping("/types/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return  typeService.findTypeByTypeId(id);
    }

    @PostMapping(value = "/types")
    public Type addType(@Valid @RequestBody Type type) {
        return typeService.addType(type);
    }

    @PutMapping("/types/{typeId}")
    public Type updateType(@PathVariable Long typeId,
                           @Valid @RequestBody Type typeRequested) {
        return typeService.editType(typeId, typeRequested);
    }

    @DeleteMapping("/types/{typeId}")
    public ResponseEntity<?> deleteType(@PathVariable Long typeId) {
        return typeService.deleteType(typeId);
    }
}

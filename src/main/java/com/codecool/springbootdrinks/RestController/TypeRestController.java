package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.TypeRepository;
import com.codecool.springbootdrinks.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/types", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public Type addType(@Valid @RequestBody Type type) {
        return typeService.addType(type);
    }

//    @PutMapping(value = "/types/{id}", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
//    public Type updateType(@PathVariable Long id, @Valid @RequestBody Type type) {
//        return typeService.editType(type);
//    }

//    @PutMapping("/types/{typeId}")
//    public Type updateType(@PathVariable Long typeId,
//                                   @Valid @RequestBody Type typeRequest) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    question.setTitle(questionRequest.getTitle());
//                    question.setDescription(questionRequest.getDescription());
//                    return questionRepository.save(question);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }

}

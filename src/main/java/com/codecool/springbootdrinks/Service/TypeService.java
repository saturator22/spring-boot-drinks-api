package com.codecool.springbootdrinks.Service;

import com.codecool.springbootdrinks.Model.Type;
import com.codecool.springbootdrinks.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    public Type findTypeByTypeId(Long id) {
        return typeRepository.findTypeByTypeId(id);
    }

    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    public Type editType(Long typeId, Type requestedType) {
        Type loadedType = typeRepository.findTypeByTypeId(typeId);
        loadedType.setTypeName(requestedType.getTypeName());
        return typeRepository.save(loadedType);
    }

    public ResponseEntity<?> deleteType(Long typeId) {
        typeRepository.delete(typeRepository.findTypeByTypeId(typeId));
        return ResponseEntity.ok().build();
    }
}

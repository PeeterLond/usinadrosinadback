package com.example.usinadrosinadback.domain.advertisement.type;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    public Type getTypeBy(Integer typeId) {
        return typeRepository.getReferenceById(typeId);
    }

    public List<Type> getAllAdvertisementTypes() {
        return typeRepository.findAll();
    }
}

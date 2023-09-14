package com.example.usinadrosinadback.domain.advertisement.chore;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoreService {

    @Resource
    private ChoreRepository choreRepository;


    public List<Chore> getAllChores() {
        return choreRepository.findAll();
    }

    public Chore getChoreBy(Integer choreId) {
        return choreRepository.getReferenceById(choreId);
    }
}

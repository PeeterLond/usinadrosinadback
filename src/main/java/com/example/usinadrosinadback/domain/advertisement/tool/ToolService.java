package com.example.usinadrosinadback.domain.advertisement.tool;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {

    @Resource
    private ToolRepository toolRepository;

    public Tool getToolBy(Integer toolId) {
        return toolRepository.getReferenceById(toolId);
    }

    public List<Tool> getAllAdvertisementTools() {
        return toolRepository.findAll();
    }
}


package com.example.usinadrosinadback.domain.advertisement.tool;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    @Resource
    private ToolRepository toolRepository;

    public Tool getToolBy(Integer toolId) {
        return toolRepository.getReferenceById(toolId);
    }
}

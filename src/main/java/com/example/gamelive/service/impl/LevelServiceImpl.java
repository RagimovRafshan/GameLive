package com.example.gamelive.service.impl;

import com.example.gamelive.dao.LevelRepository;
import com.example.gamelive.model.entity.Level;
import com.example.gamelive.service.abstr.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;

    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level update(Level level) {
        return levelRepository.save(level);
    }
}

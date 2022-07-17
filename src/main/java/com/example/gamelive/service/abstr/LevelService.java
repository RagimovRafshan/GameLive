package com.example.gamelive.service.abstr;

import com.example.gamelive.model.entity.Level;

public interface LevelService {
    Level save(Level level);
    Level update(Level level);
}

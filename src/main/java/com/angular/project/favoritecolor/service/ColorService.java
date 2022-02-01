package com.angular.project.favoritecolor.service;

import com.angular.project.favoritecolor.exceptions.ColorNotFoundException;
import com.angular.project.favoritecolor.model.Color;
import com.angular.project.favoritecolor.repo.ColorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    private final ColorRepo colorRepo;

    @Autowired
    public ColorService(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }

    public List<Color> findAllColors() {
        return colorRepo.findAll();
    }

    public Color incrementVoteById(String id) {
        Optional<Color> color = colorRepo.findById(id);
        if(color.isPresent()) {
            return colorRepo.save(new Color(id, color.get().getVotes() + 1));
        }
        else {
            throw new ColorNotFoundException(id);
        }
    }
}

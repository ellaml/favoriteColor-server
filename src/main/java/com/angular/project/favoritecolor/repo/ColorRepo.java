package com.angular.project.favoritecolor.repo;

import com.angular.project.favoritecolor.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ColorRepo extends JpaRepository<Color, String> {}

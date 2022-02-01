package com.angular.project.favoritecolor;

import com.angular.project.favoritecolor.exceptions.ColorNotFoundException;
import com.angular.project.favoritecolor.model.Color;
import com.angular.project.favoritecolor.service.ColorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorResource {
    private final ColorService colorService;

    public ColorResource(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Color>> getAllColors() {
        List<Color> colors = this.colorService.findAllColors();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @PostMapping("/{colorId}/increment-vote")
    public ResponseEntity<Color> updateColor(@PathVariable String colorId) {
        try{
            Color updatedColor = colorService.incrementVoteById(colorId);
            return new ResponseEntity<>(updatedColor, HttpStatus.OK);
        }
        catch (ColorNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

package com.angular.project.favoritecolor.exceptions;

public class ColorNotFoundException extends  RuntimeException {
    public ColorNotFoundException(String id) {
        super("Color id " + id + " not found");
    }
}

package com.angular.project.favoritecolor.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Color implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    private int votes;

    public Color() {

    }

    public Color(String code, int votes) {
        this.id = code;
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public void setId(String code) {
        this.id = code;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "color{" +
                "id='" + id + '\'' +
                ", votes=" + votes +
                '}';
    }
}

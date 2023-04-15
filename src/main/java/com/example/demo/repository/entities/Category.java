package com.example.demo.repository.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Size(max = 25)
    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = Instant.now();
    }

}
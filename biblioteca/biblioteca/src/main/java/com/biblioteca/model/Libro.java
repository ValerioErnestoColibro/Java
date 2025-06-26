package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;
    private String autore;
    private String genere;
    private int annoPubblicazione;
    private int copieDisponibili;

    public Libro() {
    }

    // Getters e Setters
}
package com.comp586.bonfilms.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "film_details")
@Data
public class FilmDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "studio")
    private String studio;

    @Column(name = "director")
    private String director;

    @Column(name = "top_billing")
    private String topBilling;

    @Column(name = "synopsis")
    private String synopsis;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmDetail")
    // private Set<Review> review;

}

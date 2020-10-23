package com.comp586.bonfilms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "film_details")
@Data
public class FilmDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmDetail")
    private Set<Review> reviews;

}

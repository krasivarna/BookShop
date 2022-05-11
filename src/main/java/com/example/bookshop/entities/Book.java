package com.example.bookshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(length = 1000)
    private String Description;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Column(name="edition_type",nullable = false)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    private int copies;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @Column(name="age_restriction",nullable = false)
    private AgeRestriction ageRestriction;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public Book() {    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Book(String title, EditionType editionType, BigDecimal price, LocalDate releaseDate,
                AgeRestriction ageRestriction, Author author, Set<Category> categories,int copies) {
        //title, editionType, price, releaseDate,
        //ageRestriction, author, categories, copies
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
        this.categories = categories;
    }

}

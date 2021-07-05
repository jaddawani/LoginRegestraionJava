package com.axsos.logandreg.models;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    @NotNull
    private String description;
    @NotNull
    private String location;
    @NotNull
    private String picture;
    @NotNull
    private String locationpic;
    @NotNull
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String adoptiondate;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User adopter;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    
    public Pet() {
    
    }
    
    public Pet(String name, String gender, String description, String location, String picture, String locationpic,
            String adoptiondate) {
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.location = location;
        this.picture = picture;
        this.locationpic = locationpic;
        this.adoptiondate = adoptiondate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getLocationpic() {
        return locationpic;
    }
    public void setLocationpic(String locationpic) {
        this.locationpic = locationpic;
    }
    public String getAdoptiondate() {
        return adoptiondate;
    }
    public void setAdoptiondate(String adoptiondate) {
        this.adoptiondate = adoptiondate;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public User getOwner() {
        return adopter;
    }
    public void setOwner(User owner) {
        this.adopter = owner;
    }
    
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
}
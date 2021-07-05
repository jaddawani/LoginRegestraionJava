package com.axsos.logandreg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    @NotNull
    private String category_name;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany( mappedBy="category",fetch = FetchType.LAZY)
    private List<Pet> pets;

    public Category() {

    }


    public Category(String category_name, List<Pet> pets) {

        this.category_name = category_name;
        this.pets = pets;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    @PrePersist
    protected void onCreate(){this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate(){this.updatedAt = new Date();}
}
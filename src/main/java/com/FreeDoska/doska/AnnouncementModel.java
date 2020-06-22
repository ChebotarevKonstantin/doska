package com.FreeDoska.doska;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
//@Data
@ToString(of = {"id", "nameAnnouncement"})
@EqualsAndHashCode(of = {"id"})
public class AnnouncementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameAnnouncement;
    private String textAnnouncement;
    private String category;
    private String subcategory;
    private String price;
    private String city;

    @Column(updatable = false)
    private LocalDateTime creationDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAnnouncement() {
        return nameAnnouncement;
    }

    public void setNameAnnouncement(String nameAnnouncement) {
        this.nameAnnouncement = nameAnnouncement;
    }

    public String getTextAnnouncement() {
        return textAnnouncement;
    }

    public void setTextAnnouncement(String textAnnouncement) {
        this.textAnnouncement = textAnnouncement;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}

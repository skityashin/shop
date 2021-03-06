package com.levelup.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Class {@link Product}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.getALL", query = "select p from Product p")

public class Product {

    private long id_prod;
    private String title_prod;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private Set<Tag> tags;

    public Product() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prod", nullable = false)
    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }


    @Transient
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Column(name="title_prod")
    public String getTitle_prod() {
        return title_prod;
    }

    public void setTitle_prod(String title_prod) {
        this.title_prod = title_prod;
    }


    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

package com.levelup.model;

import javax.persistence.*;
import java.util.List;

/**
 * Class {@link Category}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */

@Entity
@Table(name = "category")
@NamedQuery(name = "Category.getALL", query = "select c from Category c")

public class Category {

    private long id_category;
    private String title_category;
    private List<Product> products;

    public Category() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category", nullable = false)
    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }


    @Column(name = "title_category")
    public String getTitle_category() {
        return title_category;
    }

    public void setTitle_category(String title_category) {
        this.title_category = title_category;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY, targetEntity = Product.class)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

package com.levelup.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Class {@link com.levelup.model.Tag}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

@Entity
@Table(name = "tag")
@NamedQuery(name = "Tag.getALL", query = "select t from Tag t")

public class Tag {

    private long id_tag;
    private String title_tag;
    private Set<Product> products;

    public Tag() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tag", nullable = false)
    public long getId_tag() {
        return id_tag;
    }

    public void setId_tag(long id_tag) {
        this.id_tag = id_tag;
    }


    @Column(name = "title_tag")
    public String getTitle_tag() {
        return title_tag;
    }

    public void setTitle_tag(String title_tag) {
        this.title_tag = title_tag;
    }


    @ManyToMany
    @JoinTable(name = "product_tag", joinColumns = {
            @JoinColumn(name = "id_tag", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_prod",
                    nullable = false, updatable = false)})
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

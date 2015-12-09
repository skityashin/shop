package com.levelup;

import javax.persistence.*;

/**
 * Class {@link com.levelup.Category}
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

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
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
}

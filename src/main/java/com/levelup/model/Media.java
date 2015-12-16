package com.levelup.model;

import javax.persistence.*;

/**
 * Class {@link Product}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

@Entity
@Table(name = "media")
@NamedQuery(name = "Media.getALL", query = "select m from Media m")

public class Media {

    private long id_media;
    private String title_media;
    private String path;
    private double size;
    private double length;
    private double width;
    private MediaType mediaType;

    public Media() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_media", nullable = false)
    public long getId_media() {
        return id_media;
    }

    public void setId_media(long id_media) {
        this.id_media = id_media;
    }


    @Column(name = "title_media")
    public String getTitle_media() {
        return title_media;
    }

    public void setTitle_media(String title_media) {
        this.title_media = title_media;
    }


    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Column(name = "size")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    @Column(name = "length")
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    @Column(name = "width")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    @Enumerated(EnumType.STRING)
    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}

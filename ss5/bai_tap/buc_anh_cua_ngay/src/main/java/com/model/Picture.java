package com.model;

import javax.persistence.*;

@Entity(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rate;
    private String authorName;
    private String feelBack;
    private Integer likeComment;
    private String comment;

    public Picture() {
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", rate=" + rate +
                ", authorName='" + authorName + '\'' +
                ", feelBack='" + feelBack + '\'' +
                ", likeComment=" + likeComment +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getFeelBack() {
        return feelBack;
    }

    public void setFeelBack(String feelBack) {
        this.feelBack = feelBack;
    }

    public Integer getLikeComment() {
        return likeComment;
    }

    public void setLikeComment(Integer likeComment) {
        this.likeComment = likeComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

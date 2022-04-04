package com.codegym.model;

public class Mail {
    private Integer id;
    private String language;
    private Integer pageSize;
    private Integer spamsFillter;
    private String signature;

    public Mail() {
    }

    public Mail(Integer id, String language, Integer pageSize, Integer spamsFillter, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(Integer spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spamsFillter=" + spamsFillter +
                ", signature='" + signature + '\'' +
                '}';
    }
}

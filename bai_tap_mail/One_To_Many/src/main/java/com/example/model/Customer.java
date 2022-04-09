package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<SaveNote> saveNote;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SaveNote> getSaveNote() {
        return saveNote;
    }

    public void setSaveNote(Set<SaveNote> saveNote) {
        this.saveNote = saveNote;
    }
}

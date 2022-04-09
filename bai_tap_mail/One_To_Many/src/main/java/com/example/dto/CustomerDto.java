package com.example.dto;

import com.example.model.SaveNote;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto implements Validator {

    private Integer id;
    @Pattern(regexp = "([A-Z]|[a-z])+",message = "Vui lòng nhập chữ")
    @NotBlank(message = "Không được để trống")
    private String name;
    private Set<SaveNote> saveNote;

    public CustomerDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

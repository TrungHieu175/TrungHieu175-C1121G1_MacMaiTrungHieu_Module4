package com.example.bai_tap_validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotNull(message = "Không được để trống")
    @Pattern(regexp ="[09(1|3|7|8)[0-9]{7}]",message = "Số điện thoại phải có 10 số và các đầu 091,093,097,098")
    private Integer phone;
    @NotNull(message = "Không được để trống")
    @Min(value = 18,message = "Tuổi phải lớn hơn 18")
    private Integer age;
    @NotBlank(message = "Không được để trống")
    @Email(message = "Vui lòng viết đúng định dạng email")
    private String mail;

    public UserDto() {
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

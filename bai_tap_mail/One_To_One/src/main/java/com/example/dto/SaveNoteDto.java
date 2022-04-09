package com.example.dto;


import com.example.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SaveNoteDto implements Validator {

    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String timeStar;
    @Pattern(regexp = "^[0-9]+$", message = "Vui lòng nhập số")
    @NotBlank(message = "Không được để trống")
    private String term;
    @Min(value = 30000000, message = "Phải lớn hơn 30 Triệu")
    @NotNull(message = "Không được để trống")
    private Integer deposits;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;

    public SaveNoteDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStar() {
        return timeStar;
    }

    public void setTimeStar(String timeStar) {
        this.timeStar = timeStar;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SaveNoteDto saveNoteDto = (SaveNoteDto) target;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(saveNoteDto.getTimeStar(), timeFormatter);

        if (date.isBefore(now)) {
            errors.rejectValue("timeStar", "time.before", "Hãy hướng về tương lai");
        }
    }
}

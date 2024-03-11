package com.example.q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {

    @NotEmpty(message = "ID Should be not Empty")
    @Size(min = 3 ,message = "ID Should be Length more than 2")
    private String ID ;

@Digits(integer = Integer.MAX_VALUE, fraction = 0)
    @NotNull(message = "capacity Should be not Empty")
    @Min(25)
    private int capacity ;

    @NotEmpty(message = "description Should be not Empty")
    @Size(min = 15 ,message = "description Should be Length more than 15")
    private String description ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate ;
}

package com.example.q2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {
    @NotEmpty(message = "ID Should be not Empty")
    @Size(min = 3 ,message = "ID Should be Length more than 2")
    private String ID ;
    @NotEmpty(message = "Title Should be not Empty")
    @Size(min = 8 ,message = "title Should be Length more than 8")
    private String title ;
    @NotEmpty(message = "description Should be not Empty")
    @Size(min = 15 ,message = "description Should be Length more than 15")
    private String description ;
    @NotEmpty(message = "status Should be not Empty")
    @Pattern(regexp = "^(Not Started|in Progress|Completed)$")
    private String status ;
    @NotEmpty(message = "companyName Should be not Empty")
    @Size(min = 6 ,message = "companyName Should be Length more than 6")
    private String companyName ;
}

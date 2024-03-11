package com.example.q2.Controller;

import com.example.q2.Api.ApiResponse;
import com.example.q2.Model.ProjectTracker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Project")
public class ProjectTrackerController {
 ArrayList<ProjectTracker> projects = new ArrayList<>();


  @GetMapping("/getProjects")
    public ResponseEntity getProjects() {
      return ResponseEntity.status(200).body(projects);
    }

    @PostMapping("/addProject")
    public ResponseEntity addProjects(@RequestBody @Valid ProjectTracker project , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       projects.add(project);
        return ResponseEntity.status(200).body(new ApiResponse("Project added"));
    }

 @PutMapping("/update/{index}")
    public  ResponseEntity updatedProjects(@PathVariable int index, @RequestBody @Valid ProjectTracker project,Errors errors) {
     if (errors.hasErrors()) {
         String message = errors.getFieldError().getDefaultMessage();
         return ResponseEntity.status(400).body(message);
     }
  projects.set(index, project);
     return ResponseEntity.status(200).body(new ApiResponse("Project updated"));
    }

    @DeleteMapping("/delete/{index}")
    public  ResponseEntity deletedProjects(@PathVariable int index) {
        projects.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Project deleted"));
    }

    @PutMapping("/updateStatus/{index}")
    public  ResponseEntity updatedStatus(@PathVariable int index) {
        if(projects.get(index).getStatus().equalsIgnoreCase("Not Started")){
            projects.get(index).setStatus("in Progress");
            return ResponseEntity.status(200).body(new ApiResponse("Status updated"));
        }
        else if (projects.get(index).getStatus().equalsIgnoreCase("in Progress")){
            projects.get(index).setStatus("Completed");
            return ResponseEntity.status(200).body(new ApiResponse("Status updated"));
        }else
            return  ResponseEntity.status(400).body(" Status not updated");

        }

    @GetMapping("/Search/{title}")
    public ResponseEntity SearchTitle(@PathVariable String title ){
        for (ProjectTracker P : projects) {
            if (P.getTitle().equalsIgnoreCase(title))
            return ResponseEntity.status(200).body(new ApiResponse("Status updated "+P));
        }

        return ResponseEntity.status(400).body( " title is not found ");
    }

    @GetMapping("/getCompanyName/{CompanyName}")
    public ResponseEntity getCompanyName(@PathVariable String CompanyName ){
        for (ProjectTracker P : projects) {
            if (P.getCompanyName().equalsIgnoreCase(CompanyName))
                return ResponseEntity.status(200).body(new ApiResponse("Project: "+P));
        }

        return ResponseEntity.status(400).body( " Company Name is not found ");
    }
}

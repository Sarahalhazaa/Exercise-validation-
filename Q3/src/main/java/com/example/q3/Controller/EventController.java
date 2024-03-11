package com.example.q3.Controller;

import com.example.q3.Api.ApiResponse;
import com.example.q3.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/Event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();


   @GetMapping("/getEvent")
    public ResponseEntity getEvent() {
       return ResponseEntity.status(200).body(events);
    }

  @PostMapping("/addEvent")
    public ResponseEntity addEvent(@RequestBody @Valid Event event,Errors errors) {
      if (errors.hasErrors()) {
          String message = errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(message);
      }
     events.add(event);
      return ResponseEntity.status(200).body(new ApiResponse(" Event added"));
    }

   @PutMapping("/update/{index}")
    public  ResponseEntity updatedEvent(@PathVariable int index, @RequestBody @Valid Event event,Errors errors) {
       if (errors.hasErrors()) {
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       events.set(index, event);
       return ResponseEntity.status(200).body(new ApiResponse("Event updated"));
    }

    @DeleteMapping("/delete/{index}")
    public  ResponseEntity deletedEvent(@PathVariable int index) {
        events.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Event  deleted"));
    }

    @PutMapping("/updateCapacity/{index}/{capacity}")
    public ResponseEntity updatedCapacity(@PathVariable int index, @PathVariable int capacity) {

        events.get(index).setCapacity(capacity);
        return ResponseEntity.status(200).body(new ApiResponse(" Capacity Changed "));
    }

    @GetMapping("/SearchEvent/{id}")
    public ResponseEntity SearchEvent(@PathVariable String id ){
        for (Event E : events) {
            if (E.getID().equalsIgnoreCase(id))
            return ResponseEntity.status(200).body(new ApiResponse("Event: "+E));
        }
        return ResponseEntity.status(400).body(" Event is not found ");
    }

}

package br.cleilsonandrade.todosimple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/tasks")
public class ApiController {

  private List<String> tasks = new ArrayList<>();

  private ObjectMapper objectMapper;

  public ApiController(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @GetMapping
  public ResponseEntity<String> listTasks() throws JsonProcessingException {
    return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
  }

  @PostMapping
  public ResponseEntity<Void> createTask(@RequestBody String task) {
    tasks.add(task);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping
  public ResponseEntity<Void> clearTasks() {
    tasks = new ArrayList<>();
    return ResponseEntity.ok().build();
  }
}

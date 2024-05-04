package com.collegeFest.Debate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/debate/student")
public class StudentController {
	
	private final StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping
	public ReponseEntity<List<Student>> findAll(){
		List<Student> students = service.findAll();
		return ResponseEntity.ok().body(students);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> find(@PathVariable("id") int studentId){
		Optinal<Student> student = service.find(studentId);
		return ResponseEntity.of(student);
	}
	
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student){
		Student created = service.create(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(created.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(
			@PathVariable("id") int studentId,
			@RequestBody Student updatedStudent){
		
		Optional<Student> updated = service.update(id, updatedStudent);
		
		return updated
				.map(value -> ResponseEntity.ok().body(value))
				.orElseGet(() -> {
					Student created = service.create(upatedStudent);
					URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(created.getStudentId())
							.toUri();
					
					return Res;ponseEntity.created(location).body(created);
				});
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> delete(@PathVariable("id") int studentId){
		
		service.delete(studentId);
		
		return ResponseEntity.noContent().build();
	}
		
}

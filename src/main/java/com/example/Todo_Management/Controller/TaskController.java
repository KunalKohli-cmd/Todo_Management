package com.example.Todo_Management.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Todo_Management.Dto.TaskDto;
import com.example.Todo_Management.service.TaskService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

	private TaskService taskService;
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/getAll")
	public ResponseEntity<List<TaskDto>> getAllTasks(){
		List<TaskDto> allTask= taskService.getAllTasks();
		return ResponseEntity.ok(allTask);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createTask")
	public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
		TaskDto resulTaskDto=taskService.createTask(taskDto);
		return new ResponseEntity<TaskDto>(resulTaskDto,HttpStatus.CREATED);
		}
	
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/get/{ID}")
	public ResponseEntity<TaskDto> getTaskByID(@PathVariable("ID") Long id){
		TaskDto resultTaskDto=taskService.getTaskById(id);
		return new ResponseEntity<TaskDto>(resultTaskDto,HttpStatus.FOUND);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{ID}")
	public ResponseEntity<TaskDto> UpdateTaskByID(@PathVariable("ID") Long ID, @RequestBody TaskDto taskDto){
		
		TaskDto newTaskDTO=taskService.updateTaskByID(ID, taskDto);
		return ResponseEntity.ok(newTaskDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PatchMapping("/markComplete/{ID}")
	public ResponseEntity<TaskDto>markTaskCompleted(@PathVariable("ID") Long ID) {
		TaskDto taskDto = taskService.markTodoComplete(ID);
		return ResponseEntity.ok(taskDto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PatchMapping("/markInComplete/{ID}")
	public ResponseEntity<TaskDto>markTaskInCompleted(@PathVariable("ID") Long ID) {	
		TaskDto taskDto = taskService.markTodoIncomplete(ID);
		return ResponseEntity.ok(taskDto);
	}	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<String> DeleteTodo(@PathVariable("ID") Long ID){
		
		return ResponseEntity.ok(taskService.deleteTodo(ID));
	}
	
	
}

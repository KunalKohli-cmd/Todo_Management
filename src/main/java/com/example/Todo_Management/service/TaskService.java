package com.example.Todo_Management.service;

import java.util.List;

import com.example.Todo_Management.Dto.TaskDto;

public interface TaskService {
	
	TaskDto createTask(TaskDto taskDto);
	
	List<TaskDto> getAllTasks();

	TaskDto getTaskById(Long id);
	
	TaskDto updateTaskByID(Long ID, TaskDto taskDto);
	
	TaskDto markTodoComplete(Long ID);
	
	TaskDto markTodoIncomplete(Long ID);
	
	String deleteTodo(Long ID);
}

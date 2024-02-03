package com.example.Todo_Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

	Long id;
	String taskString;
	String taskDescriptionString;
	Boolean is_completed;
	
}

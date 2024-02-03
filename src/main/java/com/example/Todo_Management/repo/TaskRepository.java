package com.example.Todo_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Todo_Management.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}

package me.santander.dio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.santander.dio.domain.model.Task;
import me.santander.dio.domain.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getALLTasks() {
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
            .map(task -> {
                task.setName(updatedTask.getName());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                task.setTimeRequired(updatedTask.getTimeRequired());
                task.setDaysOfWeek(updatedTask.getDaysOfWeek());
                return taskRepository.save(task);
            })
            .orElseGet(() -> {
                updatedTask.setId(id);
                return taskRepository.save(updatedTask);
            });
    }
	
} 

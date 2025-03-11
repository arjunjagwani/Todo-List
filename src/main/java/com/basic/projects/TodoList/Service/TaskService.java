package com.basic.projects.TodoList.Service;

import com.basic.projects.TodoList.Model.Task;
import com.basic.projects.TodoList.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public void createTask(String title){
       Task task= new Task();
       task.setCompleted(false);
       task.setTitle(title);
        taskRepository.save(task);
    }
    public void deleteTasks(Long id){
        taskRepository.deleteById(id);

    }
    public void toggleTasks(Long id){
        Task task=taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}

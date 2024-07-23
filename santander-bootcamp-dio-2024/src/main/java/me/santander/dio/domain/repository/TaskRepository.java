package me.santander.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.santander.dio.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

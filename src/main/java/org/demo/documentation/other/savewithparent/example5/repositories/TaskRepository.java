package org.demo.documentation.other.savewithparent.example5.repositories;

import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}

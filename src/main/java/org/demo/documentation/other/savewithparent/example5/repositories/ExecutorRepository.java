package org.demo.documentation.other.savewithparent.example5.repositories;

import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long>, JpaSpecificationExecutor<Executor> {

}

package org.demo.documentation.getsatrted.postgres.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4002Repository extends JpaRepository<MyEntity4002, Long>, JpaSpecificationExecutor<MyEntity4002> {

}
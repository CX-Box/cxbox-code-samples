package org.demo.documentation.feature.administration.dictionary.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity356Repository extends JpaRepository<MyEntity356, Long>, JpaSpecificationExecutor<MyEntity356> {

}
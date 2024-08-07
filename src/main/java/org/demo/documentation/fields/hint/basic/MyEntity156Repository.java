package org.demo.documentation.fields.hint.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity156Repository extends JpaRepository<MyEntity156, Long>, JpaSpecificationExecutor<MyEntity156> {

}
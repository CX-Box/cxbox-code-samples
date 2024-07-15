package org.demo.documentation.fields.percent.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity7Repository extends JpaRepository<MyEntity7, Long>, JpaSpecificationExecutor<MyEntity7> {

}
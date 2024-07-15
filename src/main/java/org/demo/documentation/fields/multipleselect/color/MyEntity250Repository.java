package org.demo.documentation.fields.multipleselect.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity250Repository extends JpaRepository<MyEntity250, Long>, JpaSpecificationExecutor<MyEntity250> {

}
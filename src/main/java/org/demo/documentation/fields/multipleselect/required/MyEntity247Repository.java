package org.demo.documentation.fields.multipleselect.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity247Repository extends JpaRepository<MyEntity247, Long>, JpaSpecificationExecutor<MyEntity247> {

}
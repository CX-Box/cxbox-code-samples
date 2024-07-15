package org.demo.documentation.fields.input.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputColorRepository extends JpaRepository<InputColor, Long>, JpaSpecificationExecutor<InputColor> {

}
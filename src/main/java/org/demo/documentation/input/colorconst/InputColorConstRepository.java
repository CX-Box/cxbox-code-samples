package org.demo.documentation.input.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputColorConstRepository extends JpaRepository<InputColorConst, Long>,
		JpaSpecificationExecutor<InputColorConst> {

}
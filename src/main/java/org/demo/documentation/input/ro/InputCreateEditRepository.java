package org.demo.documentation.input.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputCreateEditRepository extends JpaRepository<InputCreateEdit, Long>,
		JpaSpecificationExecutor<InputCreateEdit> {

}
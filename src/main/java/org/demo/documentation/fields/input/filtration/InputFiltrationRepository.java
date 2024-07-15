package org.demo.documentation.fields.input.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputFiltrationRepository extends JpaRepository<InputFiltration, Long>,
		JpaSpecificationExecutor<InputFiltration> {

}
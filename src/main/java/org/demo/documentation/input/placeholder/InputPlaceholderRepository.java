package org.demo.documentation.input.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputPlaceholderRepository extends JpaRepository<InputPlaceholder, Long>,
		JpaSpecificationExecutor<InputPlaceholder> {

}
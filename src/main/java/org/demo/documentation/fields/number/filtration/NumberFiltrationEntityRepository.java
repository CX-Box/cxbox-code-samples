package org.demo.documentation.fields.number.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberFiltrationEntityRepository extends JpaRepository<NumberFiltrationEntity, Long>,
		JpaSpecificationExecutor<NumberFiltrationEntity> {

}
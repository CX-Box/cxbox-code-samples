package org.demo.documentation.fields.number.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity2337Repository extends JpaRepository<MyEntity2337, Long>,
		JpaSpecificationExecutor<MyEntity2337> {

}
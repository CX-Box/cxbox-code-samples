package org.demo.documentation.picklist.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity401PickRepository extends JpaRepository<MyEntity401Pick, Long>,
		JpaSpecificationExecutor<MyEntity401Pick> {

}
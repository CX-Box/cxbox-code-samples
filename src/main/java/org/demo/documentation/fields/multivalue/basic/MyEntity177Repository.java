package org.demo.documentation.fields.multivalue.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity177Repository extends JpaRepository<MyEntityMultivalue177, Long>, JpaSpecificationExecutor<MyEntityMultivalue177> {

}
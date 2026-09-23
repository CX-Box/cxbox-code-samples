package org.demo.documentation.fields.richtext.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity432Repository extends JpaRepository<MyEntity432, Long>, JpaSpecificationExecutor<MyEntity432> {

}
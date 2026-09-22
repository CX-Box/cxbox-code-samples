package org.demo.documentation.fields.richtext.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity430Repository extends JpaRepository<MyEntity430, Long>, JpaSpecificationExecutor<MyEntity430> {

}
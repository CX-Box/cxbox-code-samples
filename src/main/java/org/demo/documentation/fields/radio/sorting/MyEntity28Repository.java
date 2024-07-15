package org.demo.documentation.fields.radio.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity28Repository extends JpaRepository<MyEntity28, Long>, JpaSpecificationExecutor<MyEntity28> {

}
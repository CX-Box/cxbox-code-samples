package org.demo.documentation.fields.richtext.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity429Repository extends JpaRepository<MyEntity429, Long>, JpaSpecificationExecutor<MyEntity429> {

}
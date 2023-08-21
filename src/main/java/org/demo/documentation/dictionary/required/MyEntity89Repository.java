package org.demo.documentation.dictionary.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity89Repository extends JpaRepository<MyEntity89, Long>, JpaSpecificationExecutor<MyEntity89> {

}
package org.demo.documentation.fields.dictionary.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity88Repository extends JpaRepository<MyEntity88, Long>, JpaSpecificationExecutor<MyEntity88> {

}
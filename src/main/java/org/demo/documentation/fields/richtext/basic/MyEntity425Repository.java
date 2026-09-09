package org.demo.documentation.fields.richtext.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity425Repository extends JpaRepository<MyEntity425, Long>, JpaSpecificationExecutor<MyEntity425> {

}

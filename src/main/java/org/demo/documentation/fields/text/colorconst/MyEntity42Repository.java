package org.demo.documentation.fields.text.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity42Repository extends JpaRepository<MyEntity42, Long>, JpaSpecificationExecutor<MyEntity42> {

}
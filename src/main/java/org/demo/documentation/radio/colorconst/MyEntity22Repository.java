package org.demo.documentation.radio.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity22Repository extends JpaRepository<MyEntity22, Long>, JpaSpecificationExecutor<MyEntity22> {

}
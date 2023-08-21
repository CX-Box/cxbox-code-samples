package org.demo.documentation.dateytimewithseconds.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity322Repository extends JpaRepository<MyEntity322, Long>, JpaSpecificationExecutor<MyEntity322> {

}
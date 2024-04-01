package org.demo.microservicestoringdata.repository;

import org.demo.microservicestoringdata.repository.entity.MyEntity3900;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3900Repository extends JpaRepository<MyEntity3900, Long>, JpaSpecificationExecutor<MyEntity3900> {

}
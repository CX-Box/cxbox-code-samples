package org.demo.microservicestoringdata.repository;


import org.demo.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.microservicestoringdata.repository.entity.MyEntity3900;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3900Repository extends
 JpaRepository<MyEntity3900, Long>, JpaSpecificationExecutor<MyEntity3900>,
        QueryLanguageRepository<MyEntity3900, Long> {


     public List <MyEntity3900> findAllByCustomField(String customField);
}
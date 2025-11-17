package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4903PickOCPRepository extends JpaRepository<MyEntity4903OCPPick, Long>, JpaSpecificationExecutor<MyEntity4903OCPPick> {

    MyEntity4903OCPPick findByCustomField(String customField);
}

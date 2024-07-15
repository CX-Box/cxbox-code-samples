package org.demo.documentation.fields.money.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity333Repository extends JpaRepository<MyEntity333, Long>, JpaSpecificationExecutor<MyEntity333> {

}
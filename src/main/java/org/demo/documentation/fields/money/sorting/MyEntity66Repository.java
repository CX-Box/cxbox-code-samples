package org.demo.documentation.fields.money.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity66Repository extends JpaRepository<MyEntity66, Long>, JpaSpecificationExecutor<MyEntity66> {

}
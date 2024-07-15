package org.demo.documentation.fields.money.withoutdigits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity305Repository extends JpaRepository<MyEntity305, Long>, JpaSpecificationExecutor<MyEntity305> {

}
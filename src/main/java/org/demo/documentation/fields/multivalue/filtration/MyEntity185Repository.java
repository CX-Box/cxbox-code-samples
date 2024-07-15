package org.demo.documentation.fields.multivalue.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity185Repository extends JpaRepository<MyEntity185, Long>, JpaSpecificationExecutor<MyEntity185> {

}
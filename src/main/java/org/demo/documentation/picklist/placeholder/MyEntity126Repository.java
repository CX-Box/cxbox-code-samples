package org.demo.documentation.picklist.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity126Repository extends JpaRepository<MyEntity126, Long>, JpaSpecificationExecutor<MyEntity126> {

}
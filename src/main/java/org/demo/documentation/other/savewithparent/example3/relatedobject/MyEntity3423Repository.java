package org.demo.documentation.other.savewithparent.example3.relatedobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3423Repository extends JpaRepository<MyEntity3423, Long>, JpaSpecificationExecutor<MyEntity3423> {

}

package org.demo.documentation.other.savewithparent.example3.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3425Repository extends JpaRepository<MyEntity3425, Long>, JpaSpecificationExecutor<MyEntity3425> {

}

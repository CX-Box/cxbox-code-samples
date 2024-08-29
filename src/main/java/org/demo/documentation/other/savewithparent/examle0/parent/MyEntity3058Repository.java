package org.demo.documentation.other.savewithparent.examle0.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3058Repository extends JpaRepository<MyEntity3058, Long>, JpaSpecificationExecutor<MyEntity3058> {

}

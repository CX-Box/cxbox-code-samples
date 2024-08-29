package org.demo.documentation.other.savewithparent.example2.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3131Repository extends JpaRepository<MyEntity3131, Long>, JpaSpecificationExecutor<MyEntity3131> {

}

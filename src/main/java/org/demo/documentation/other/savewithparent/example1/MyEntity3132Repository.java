package org.demo.documentation.other.savewithparent.example1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3132Repository extends JpaRepository<MyEntity3132, Long>, JpaSpecificationExecutor<MyEntity3132> {

}

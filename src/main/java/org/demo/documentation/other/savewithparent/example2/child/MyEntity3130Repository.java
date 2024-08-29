package org.demo.documentation.other.savewithparent.example2.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3130Repository extends JpaRepository<MyEntity3130, Long>, JpaSpecificationExecutor<MyEntity3130> {

}

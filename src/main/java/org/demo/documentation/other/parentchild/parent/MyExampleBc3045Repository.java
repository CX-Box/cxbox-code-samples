package org.demo.documentation.other.parentchild.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc3045Repository extends JpaRepository<MyExampleBc3045, Long>, JpaSpecificationExecutor<MyExampleBc3045> {


}

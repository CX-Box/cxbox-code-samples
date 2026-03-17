package org.demo.documentation.other.parentchild.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc3045ChildRepository extends JpaRepository<MyExampleBc3045Child, Long>, JpaSpecificationExecutor<MyExampleBc3045Child> {


}

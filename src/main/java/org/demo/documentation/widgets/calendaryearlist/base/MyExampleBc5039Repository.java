package org.demo.documentation.widgets.calendaryearlist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc5039Repository extends JpaRepository<MyExampleBc5039, Long>, JpaSpecificationExecutor<MyExampleBc5039> {


}

package org.demo.documentation.widgets.property.defaultlimitpage.forassoc;

import org.demo.documentation.widgets.property.defaultlimitpage.MyEntity359;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity359AssocRepository extends JpaRepository<MyEntity359Assoc, Long>, JpaSpecificationExecutor<MyEntity359Assoc> {

}

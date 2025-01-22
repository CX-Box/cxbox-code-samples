package org.demo.documentation.widgets.property.defaultlimitpage.forpick;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity359PickRepository extends JpaRepository<MyEntity359Pick, Long>, JpaSpecificationExecutor<MyEntity359Pick> {

}

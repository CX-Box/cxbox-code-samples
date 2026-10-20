package org.demo.documentation.widgets.property.defaultlimitpage.forcardlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity359CardRepository extends JpaRepository<MyEntity359Card, Long>, JpaSpecificationExecutor<MyEntity359Card> {

}

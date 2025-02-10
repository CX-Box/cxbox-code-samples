package org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction;

import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3126Repository extends JpaRepository<MyEntity3126, Long>, JpaSpecificationExecutor<MyEntity3126> {

    List<MyEntity3126> findAllByLocationAndObject(String location,String object);
    List<MyEntity3126> findAllByLocation(String location);
}

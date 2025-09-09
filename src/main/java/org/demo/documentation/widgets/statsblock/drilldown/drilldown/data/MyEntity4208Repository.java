package org.demo.documentation.widgets.statsblock.drilldown.drilldown.data;

import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldRegion;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity4208Repository extends JpaRepository<MyEntity4208, Long>, JpaSpecificationExecutor<MyEntity4208> {
    default Specification<MyEntity4208> statusIn(List<CustomFieldEnum> clientStatusList) {
        return (root, query, cb) -> root.get(MyEntity4208_.customFieldStatus).in(clientStatusList);
    }

    default Specification<MyEntity4208> statusInRegionIn(List<CustomFieldEnum> clientStatusList, List<CustomFieldRegion> customFieldRegionList) {
        return (root, query, cb) -> cb.and(
                cb.in(root.get(MyEntity4208_.customFieldStatus).in(clientStatusList)),
                cb.in(root.get(MyEntity4208_.customFieldRegion).in(customFieldRegionList))
        );

    }

}
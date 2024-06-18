package org.demo.documentation.widgets.statsblock.drilldown.data;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity4208Repository extends JpaRepository<MyEntity4208, Long>, JpaSpecificationExecutor<MyEntity4208> {
    default Specification<MyEntity4208> statusIn(List<MyEntity4208> clientStatusList) {
        return (root, query, cb) -> root.get(MyEntity4208_.customFieldStatus).in(clientStatusList);
    }
}
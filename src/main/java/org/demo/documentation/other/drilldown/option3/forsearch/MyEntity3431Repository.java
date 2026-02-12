package org.demo.documentation.other.drilldown.option3.forsearch;

import org.demo.documentation.other.drilldown.option3.MyEntity3430;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyEntity3431Repository extends JpaRepository<MyEntity3431, Long>, JpaSpecificationExecutor<MyEntity3430> {

	Optional<MyEntity3431> findByUserId(Long userId);

}

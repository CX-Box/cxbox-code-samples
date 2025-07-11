package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntity4300PostActionWithCustomBuilderRepository extends JpaRepository<MyEntity4300PostActionWithCustomBuilder, Long> {

	MyEntity4300PostActionWithCustomBuilder findByCustomField(String customField);

}

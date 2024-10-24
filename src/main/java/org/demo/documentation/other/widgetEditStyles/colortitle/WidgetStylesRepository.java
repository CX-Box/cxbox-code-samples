package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetStylesRepository extends JpaRepository<WidgetStyles, Long>, JpaSpecificationExecutor<WidgetStyles> {

}

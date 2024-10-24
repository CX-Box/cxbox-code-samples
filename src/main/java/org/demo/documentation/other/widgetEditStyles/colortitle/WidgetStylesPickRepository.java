package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesPicklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetStylesPickRepository extends JpaRepository<WidgetStylesPicklist, Long>, JpaSpecificationExecutor<WidgetStylesPicklist> {

}

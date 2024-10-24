package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesInlinePicklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetStylesInlineRepository extends JpaRepository<WidgetStylesInlinePicklist, Long>, JpaSpecificationExecutor<WidgetStylesInlinePicklist> {

}

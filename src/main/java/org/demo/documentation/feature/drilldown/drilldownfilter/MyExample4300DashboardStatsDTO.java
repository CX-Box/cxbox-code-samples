package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;


@Getter
@Setter
public class MyExample4300DashboardStatsDTO extends DataResponseDTO {
	private String title = "Matching records";
	private Long value;
	private String icon = "filter";
	private String description;
}

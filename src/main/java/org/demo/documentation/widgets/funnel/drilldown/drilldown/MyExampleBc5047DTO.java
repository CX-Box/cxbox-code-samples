package org.demo.documentation.widgets.funnel.drilldown.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyExampleBc5047DTO extends DataResponseDTO {

	private String title;

	private Long value;

	private String color;

	private String description;

	private String icon;

	private Long amount;

	private String funnelKey;
}

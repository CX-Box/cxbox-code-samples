package org.demo.documentation.widgets.statsblock.title.withouttitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4225DTO extends DataResponseDTO {
	private String title;

	private Long value;

	private String color;

	private String description;

	private String icon;
}
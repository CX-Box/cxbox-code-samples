package org.demo.documentation.widgets.funnel.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyExampleBc5041DTO extends DataResponseDTO {

	private String title;

	private Long value;

	private String color;

	private String description;

	private String icon;

}

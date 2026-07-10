package org.demo.documentation.widgets.pie1d.title.withtitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4220DTO extends DataResponseDTO {

	private String title;

	private Long value;

	private String description;
}

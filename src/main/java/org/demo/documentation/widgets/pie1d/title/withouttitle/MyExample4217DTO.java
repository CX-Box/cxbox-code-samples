package org.demo.documentation.widgets.pie1d.title.withouttitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4217DTO extends DataResponseDTO {

	private String title;

	private Long value;

	private String description;
}

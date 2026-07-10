package org.demo.documentation.widgets.ringprogress.base.defaultfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4207DTO extends DataResponseDTO {

	private String title;

	private Long value;

	private String description;
}

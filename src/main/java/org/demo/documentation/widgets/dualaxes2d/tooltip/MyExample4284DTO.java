package org.demo.documentation.widgets.dualaxes2d.tooltip;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.dualaxes2d.data.ProductEnum;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4284DTO extends DataResponseDTO {

	private String month;

	private ProductEnum productName;

	private Long sum;

	private Long count;

	private String description;

}

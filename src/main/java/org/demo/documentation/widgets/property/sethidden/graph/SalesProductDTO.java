package org.demo.documentation.widgets.property.sethidden.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class SalesProductDTO extends DataResponseDTO {

	private ProductNameEnum productName;

	private String clientName;

	private Long sum;

	private String color;

}

package org.demo.documentation.widgets.relationGraph.fieldkeys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample6164DTO extends DataResponseDTO {

	private String parentCompanyId;

	private String companyId;

	private String targetNodeName;

	private Long edgeValue;

}

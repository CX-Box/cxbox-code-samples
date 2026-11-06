package org.demo.documentation.feature.drilldown.drilldowntooltip;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3626DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldDrillDown;

	private String customFieldFilterDrillDown;

	private String customFieldExternalDrillDown;

	public MyExample3626DTO(MyEntity3626 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDrillDown = entity.getCustomFieldDrillDown();
		this.customFieldFilterDrillDown = entity.getCustomFieldFilterDrillDown();
		this.customFieldExternalDrillDown = entity.getCustomFieldExternalDrillDown();
	}

}

package org.demo.documentation.widgets.statsblock.drilldown.drilldown.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;


@Getter
@Setter
@NoArgsConstructor
public class MyExample4208DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldStatus", provider = EnumValueProvider.class)
	private CustomFieldEnum customFieldStatus;
	@SearchParameter(name = "customField")
	private String customField;

	public MyExample4208DTO(MyEntity4208 entity) {
		this.id = entity.getId().toString();
		this.customFieldStatus = entity.getCustomFieldStatus();
		this.customField = entity.getCustomField();
	}
}
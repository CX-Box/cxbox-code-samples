package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300InlinePickListDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String value;

	public MyExample4300InlinePickListDTO(MyEntity4300InlinePickList entity) {
		this.id = entity.getId().toString();
		this.value = entity.getValue();
	}

}

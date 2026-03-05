package org.demo.documentation.other.assoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.drilldown.option.MyEntity3421;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3421PickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public MyEntity3421PickDTO(MyEntity3421 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}

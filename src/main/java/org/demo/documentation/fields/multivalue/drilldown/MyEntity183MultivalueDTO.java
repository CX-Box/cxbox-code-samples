package org.demo.documentation.fields.multivalue.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity183MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity183MultivalueDTO(MyEntity183 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}

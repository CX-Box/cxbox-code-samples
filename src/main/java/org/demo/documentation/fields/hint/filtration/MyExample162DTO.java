package org.demo.documentation.fields.hint.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample162DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
	private String customField;

	public MyExample162DTO(MyEntity162 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
package org.demo.documentation.multifield.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample160DTO extends DataResponseDTO {


	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldAdditional")
	private String customFieldAdditional;

	private String informationField;

	@SearchParameter(name = "customFieldMulti")
	private String customFieldMulti;

	@SearchParameter(name = "customFieldAdditionalMulti")
	private String customFieldAdditionalMulti;

	public MyExample160DTO(MyEntity160 entity) {
		this.id = entity.getId().toString();

		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
		this.informationField = entity.getInformationField();
		this.customFieldMulti = entity.getCustomFieldMulti();
		this.customFieldAdditionalMulti = entity.getCustomFieldAdditionalMulti();
	}

}
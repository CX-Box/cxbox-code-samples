package org.demo.documentation.fileupload.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample324DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	@SearchParameter(name = "customFieldId", provider = StringValueProvider.class)
	private String customFieldId;

	@SearchParameter(name = "customFieldAdditional", provider = StringValueProvider.class)
	private String customFieldAdditional;

	@SearchParameter(name = "customFieldAdditionalId", provider = StringValueProvider.class)
	private String customFieldAdditionalId;

	public MyExample324DTO(MyEntity324 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
		this.customFieldAdditionalId = entity.getCustomFieldAdditionalId();
	}

}
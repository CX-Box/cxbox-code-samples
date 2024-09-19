package org.demo.documentation.fields.picklist.validationdynamic;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample400DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "")
	private String customFieldAdditional;

	private Long customFieldId;

	public MyExample400DTO(MyEntity400 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldAdditional = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomFieldAdditional())
				.orElse(null);
	}

}
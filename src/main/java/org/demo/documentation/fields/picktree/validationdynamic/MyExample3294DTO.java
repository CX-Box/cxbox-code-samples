package org.demo.documentation.fields.picktree.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3294DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.customFieldAdditional")
	private String customFieldAdditional;

	private Long customFieldId;

	public MyExample3294DTO(MyEntity3294 entity) {
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
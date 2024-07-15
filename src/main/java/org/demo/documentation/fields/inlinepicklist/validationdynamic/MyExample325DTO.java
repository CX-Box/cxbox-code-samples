package org.demo.documentation.fields.inlinepicklist.validationdynamic;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
public class MyExample325DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.customFieldAdditional")
	private String customFieldAdditional;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	public MyExample325DTO(MyEntity325 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(BaseEntity::getId)
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(MyEntity327::getCustomField)
				.orElse(null);
		this.customFieldAdditional = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(MyEntity327::getCustomFieldAdditional)
				.orElse(null);
	}

}
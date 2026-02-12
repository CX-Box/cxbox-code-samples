package org.demo.documentation.fields.inlinepicklist.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample142DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	public MyExample142DTO(MyEntity142 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(BaseEntity::getId)
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(MyEntity143::getCustomField)
				.orElse(null);
	}

}
package org.demo.documentation.fields.picklist.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample119DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	private String customFieldColor;

	public MyExample119DTO(MyEntity119 entity) {
		this.id = entity.getId().toString();
		this.customFieldColor = "#eda6a6";
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}

}
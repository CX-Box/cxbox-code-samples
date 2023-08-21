package org.demo.documentation.inlinepicklist.color;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.color.picklist.MyEntity135;

@Getter
@Setter
@NoArgsConstructor
public class MyExample134DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	private String customFieldColor;

	public MyExample134DTO(MyEntity134 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(BaseEntity::getId)
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(MyEntity135::getCustomField)
				.orElse(null);
		this.customFieldColor = "#eda6a6";
	}

}
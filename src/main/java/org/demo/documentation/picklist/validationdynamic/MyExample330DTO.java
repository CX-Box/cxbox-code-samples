package org.demo.documentation.picklist.validationdynamic;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample330DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	@SearchParameter(name = "customFieldEntity.customFieldAdditional")
	private String customFieldAdditional;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldAdditionalId;


	public MyExample330DTO(MyEntity330 entity) {
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
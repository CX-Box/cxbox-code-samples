package org.demo.documentation.picklist.sorting;

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
public class MyExample113DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	public MyExample113DTO(MyEntity113 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}

}
package org.demo.documentation.widgets.picklist.actions.save;

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
public class MyExample3197DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldPickList;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;

	public MyExample3197DTO(MyEntity3197 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}
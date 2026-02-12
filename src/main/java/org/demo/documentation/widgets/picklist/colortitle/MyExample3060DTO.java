package org.demo.documentation.widgets.picklist.colortitle;

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
public class MyExample3060DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldPicklistEntity.customField")
	private String customFieldPicklist;
	@SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicklistId;
	@SearchParameter(name = "customFieldPicklistColorConstEntity.customField")
	private String customFieldPicklistColorConst;
	@SearchParameter(name = "customFieldPicklistColorConstEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicklistColorConstId;

	public MyExample3060DTO(MyEntity3060 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPicklistColorConstId = Optional.ofNullable(entity.getCustomFieldPicklistColorConstEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicklistColorConst = Optional.ofNullable(entity.getCustomFieldPicklistColorConstEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}
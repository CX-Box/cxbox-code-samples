package org.demo.documentation.widgets.picklist.actions.create;

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
public class MyExample3072DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldEntity.customFieldPick")
	private String customField;
	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;
	@SearchParameter(name = "customFieldInlinePicklistEntity.customFieldPick")
	private String customFieldInlinePicklist;
	@SearchParameter(name = "customFieldInlinePicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlinePicklistId;

	public MyExample3072DTO(MyEntity3072 entity) {
		this.id = entity.getId().toString();

		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomFieldPick())
				.orElse(null);
		this.customFieldInlinePicklistId = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInlinePicklist = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
				.map(e -> e.getCustomFieldPick())
				.orElse(null);
	}
}
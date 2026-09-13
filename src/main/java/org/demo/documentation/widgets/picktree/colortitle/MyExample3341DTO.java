package org.demo.documentation.widgets.picktree.colortitle;

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
public class MyExample3341DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldPicktreeEntity.customField")
	private String customFieldPicktree;
	@SearchParameter(name = "customFieldPicktreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicktreeId;
	@SearchParameter(name = "customFieldPicktreeColorConstEntity.customField")
	private String customFieldPicktreeColorConst;
	@SearchParameter(name = "customFieldPicktreeColorConstEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicktreeColorConstId;

	public MyExample3341DTO(MyEntity3341 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPicktreeId = Optional.ofNullable(entity.getCustomFieldPicktreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicktree = Optional.ofNullable(entity.getCustomFieldPicktreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPicktreeColorConstId = Optional.ofNullable(entity.getCustomFieldPicktreeColorConstEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicktreeColorConst = Optional.ofNullable(entity.getCustomFieldPicktreeColorConstEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}
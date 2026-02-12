package org.demo.documentation.widgets.property.pagination.hidelimitoptions.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3865DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldPickList;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;

	public MyExample3865DTO(MyEntity3865 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3865Multi::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}
}
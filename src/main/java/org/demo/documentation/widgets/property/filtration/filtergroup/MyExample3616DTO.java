package org.demo.documentation.widgets.property.filtration.filtergroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3616DTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldNew")
	private String customFieldNew;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldPicklistEntity.customField")
	private String customFieldPicklist;
	@SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicklistId;

	public MyExample3616DTO(MyEntity3616 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNew = entity.getCustomFieldNew();
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3623::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}
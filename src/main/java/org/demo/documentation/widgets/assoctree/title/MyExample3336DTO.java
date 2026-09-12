package org.demo.documentation.widgets.assoctree.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3336DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;

	public MyExample3336DTO(MyEntity3336 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3336Multi::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}
}
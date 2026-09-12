package org.demo.documentation.widgets.assoctree.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330Multi;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3330DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;
	private String customFieldDisplayedKey;
	@SearchParameter(name = "customFieldNew")
	private String customFieldNew;

	public MyExample3330DTO(MyEntity3330 entity) {
		this.id = entity.getId().toString();

		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3330Multi::getCustomField
		));
		this.customFieldDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity3330Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldNew = entity.getCustomFieldNew();
	}
}
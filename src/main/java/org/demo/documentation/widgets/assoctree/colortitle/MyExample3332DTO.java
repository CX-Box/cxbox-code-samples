package org.demo.documentation.widgets.assoctree.colortitle;

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
public class MyExample3332DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldMultiList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMulti;
	private String customFieldMultiDisplayedKey;
	@SearchParameter(name = "customFieldMultiConstList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultiConst;
	private String customFieldMultiConstDisplayedKey;

	public MyExample3332DTO(MyEntity3332 entity) {
		this.id = entity.getId().toString();

		this.customFieldMulti = entity.getCustomFieldMultiList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultiDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultiList().stream().map(MyEntity3332Multi::getCustomField
		).map(String::valueOf).collect(Collectors.joining(",")), 12);
		this.customFieldMultiConst = entity.getCustomFieldMultiConstList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultiConstDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultiConstList().stream().map(MyEntity3332Multi::getCustomField
		).map(String::valueOf).collect(Collectors.joining(",")), 12);
	}
}
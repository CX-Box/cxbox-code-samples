package org.demo.documentation.fields.multivaluehover.required;

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
public class MyExample236DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldMultiHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultiHover;
	private String customFieldMultiHoverDisplayedKey;

	public MyExample236DTO(MyEntity236 entity) {
		this.id = entity.getId().toString();
		this.customFieldMultiHover = entity.getCustomFieldMultiHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultiHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultiHoverList().stream().map(MyEntity238::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}

}
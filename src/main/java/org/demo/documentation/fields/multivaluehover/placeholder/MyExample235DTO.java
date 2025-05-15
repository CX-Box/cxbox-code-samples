package org.demo.documentation.fields.multivaluehover.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample235DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Double customField;
	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;
	private String customFieldMultivalueHoverDisplayedKey;

	public MyExample235DTO(MyEntity235 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntityMulti235::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}

}
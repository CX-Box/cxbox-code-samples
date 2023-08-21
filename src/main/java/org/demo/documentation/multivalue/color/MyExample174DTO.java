package org.demo.documentation.multivalue.color;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample174DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldColor;

	private String customFieldCalc;

	public MyExample174DTO(MyEntity174 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity175::getCustomField
		));
		this.customFieldColor = "#eda6a6";
		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity175::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}
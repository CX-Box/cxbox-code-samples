package org.demo.documentation.multivalue.colorconst;

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
public class MyExample178DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	public MyExample178DTO(MyEntity178 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity179::getCustomField
		));
		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity179::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}
package org.demo.documentation.multivalue.basic;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample176DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	@SearchParameter(name = "customFieldAdditional")
	private String customFieldAdditional;

	public MyExample176DTO(MyEntity176 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntityMultivalue177::getCustomField
		));

		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntityMultivalue177::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}
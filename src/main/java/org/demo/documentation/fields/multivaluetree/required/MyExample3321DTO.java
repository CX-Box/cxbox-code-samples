package org.demo.documentation.fields.multivaluetree.required;

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
public class MyExample3321DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	public MyExample3321DTO(MyEntity3321 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3321Multivalue::getCustomField
		));
		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity3321Multivalue::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}
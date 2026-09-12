package org.demo.documentation.fields.multivaluetree.validationannotation;

import jakarta.validation.constraints.NotNull;
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
public class MyExample3324DTO extends DataResponseDTO {

	@NotNull(message = "Custom message about error")
	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	public MyExample3324DTO(MyEntity3324 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3324Multivalue::getCustomField
		));
		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity3324Multivalue::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}
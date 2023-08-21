package org.demo.documentation.multivalue.validationannotation;

import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
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
public class MyExample198DTO extends DataResponseDTO {

	@NotNull(message = "Custom message about required field")
	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	public MyExample198DTO(MyEntity198 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity199::getCustomField
		));
		this.customFieldCalc = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity199::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}
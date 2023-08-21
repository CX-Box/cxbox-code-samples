package org.demo.documentation.multipleselect.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.multipleselect.drilldown.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample255DTO extends DataResponseDTO {

	@SearchParameter(name = "customField.value", multiFieldKey = StringValueProvider.class)
	private MultivalueField customField;

	public MyExample255DTO(MyEntity255 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
	}

}
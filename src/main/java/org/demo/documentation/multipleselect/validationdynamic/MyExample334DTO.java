package org.demo.documentation.multipleselect.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.multipleselect.validationconfirm.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample334DTO extends DataResponseDTO {

	@SearchParameter(name = "customField.value", multiFieldKey = StringValueProvider.class)
	private MultivalueField customField;

	@SearchParameter(name = "customFieldAdditional.value", multiFieldKey = StringValueProvider.class)
	private MultivalueField customFieldAdditional;

	public MyExample334DTO(MyEntity334 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
		this.customFieldAdditional = entity.getCustomFieldAdditional().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
	}

}
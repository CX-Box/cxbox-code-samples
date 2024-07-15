package org.demo.documentation.fields.multipleselect.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;

import org.demo.documentation.fields.multipleselect.colorconst.enums.CustomFieldEnum;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample254DTO extends DataResponseDTO {

	@EnumValueProvider.BaseEnum(value = CustomFieldEnum.class)
	@SearchParameter(name = "customField", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	private MultivalueField customField;

	public MyExample254DTO(MyEntity254 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
	}

}
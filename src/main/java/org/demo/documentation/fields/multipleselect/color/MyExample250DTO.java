package org.demo.documentation.fields.multipleselect.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.demo.documentation.fields.multipleselect.color.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample250DTO extends DataResponseDTO {

	@EnumValueProvider.BaseEnum(value = CustomFieldEnum.class)
	@SearchParameter(name = "customField", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	private MultivalueField customField;

	private String customFieldColor;

	public MyExample250DTO(MyEntity250 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
		this.customFieldColor = "#eda6a6";
	}

}
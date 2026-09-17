package org.demo.documentation.fields.multipleselect.longvalues;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.demo.documentation.fields.multipleselect.longvalues.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3358DTO extends DataResponseDTO {

	@EnumValueProvider.BaseEnum(value = CustomFieldEnum.class)
	@SearchParameter(name = "customField", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	private MultivalueField customField;

	@SearchParameter(name = "comment")
	private String comment;

	public MyExample3358DTO(MyEntity3358 entity) {
		this.id = entity.getId().toString();
		this.comment = entity.getComment();
		this.customField = entity.getCustomField().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldEnum::getValue));
	}

}
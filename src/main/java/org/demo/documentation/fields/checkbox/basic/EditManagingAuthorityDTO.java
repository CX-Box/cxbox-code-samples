package org.demo.documentation.fields.checkbox.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.checkbox.basic.enums.TypesEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class EditManagingAuthorityDTO extends DataResponseDTO {


	@SearchParameter(name = "partyType", provider = StringValueProvider.class)
	private String partyType;

	@SearchParameter(name = "partyName", provider = StringValueProvider.class)
	private String partyName;

	@SearchParameter(name = "partyInn", provider = StringValueProvider.class)
	private String partyInn;

	@SearchParameter(name = "types", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = TypesEnum.class)
	private MultivalueField types;

	@SearchParameter(name = "otherType", provider = StringValueProvider.class)
	private String otherType;

	public EditManagingAuthorityDTO(EditManagingAuthority entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.partyType = entity.getPartyType();
		this.partyName = entity.getPartyName();
		this.partyInn = entity.getPartyInn();
		this.types = entity.getTypes().stream().collect(MultivalueField.toMultivalueField(Enum::name, TypesEnum::getValue));
		this.otherType = entity.getOtherType();
	}

}

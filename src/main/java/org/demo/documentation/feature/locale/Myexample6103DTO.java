package org.demo.documentation.feature.locale;

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
import org.demo.documentation.feature.locale.dictionary.ClientImportance;
import org.demo.documentation.feature.locale.enums.FieldOfActivityEnum;
import org.demo.documentation.feature.locale.enums.StatusEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample6103DTO extends DataResponseDTO {


	@SearchParameter(name = "fullName", provider = StringValueProvider.class)
	private String fullName;

	@SearchParameter(name = "fieldOfActivity", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = FieldOfActivityEnum.class)
	private MultivalueField fieldOfActivity;

	@SearchParameter(name = "address", provider = StringValueProvider.class)
	private String address;

	@SearchParameter(name = "importance", provider = EnumValueProvider.class)
	private ClientImportance importance;

	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusEnum status;

	public Myexample6103DTO(Myexample6103 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.fullName = entity.getFullName();
		this.fieldOfActivity = entity.getFieldOfActivity().stream().collect(MultivalueField.toMultivalueField(Enum::name, FieldOfActivityEnum::getValue));
		this.address = entity.getAddress();
		this.importance = entity.getImportance();
		this.status = entity.getStatus();
	}

}

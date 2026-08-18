package org.demo.documentation.widgets.tree.data.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class My3261UsersDTO extends DataResponseDTO {


	@SearchParameter(name = "lastName")
	private String lastName;

	@SearchParameter(name = "firstName")
	private String firstName;

	@SearchParameter(name = "middleName")
	private String middleName;

	private String fullName;

	public My3261UsersDTO(My3261Users entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.lastName = entity.getLastName();
		this.firstName = entity.getFirstName();
		this.middleName = entity.getMiddleName();
		this.fullName = entity.getFirstName() + entity.getLastName() + entity.getMiddleName();
	}

}

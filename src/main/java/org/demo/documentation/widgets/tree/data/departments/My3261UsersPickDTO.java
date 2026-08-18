package org.demo.documentation.widgets.tree.data.departments;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.tree.data.users.My3261Users;

@Getter
@Setter
@NoArgsConstructor
public class My3261UsersPickDTO extends DataResponseDTO {

	@SearchParameter(name = "lastName")
	private String lastName;

	@SearchParameter(name = "firstName")
	private String firstName;

	@SearchParameter(name = "middleName")
	private String middleName;

	private String fullName;

	public My3261UsersPickDTO(My3261Users entity) {
		this.id = entity.getId().toString();
		this.lastName = entity.getLastName();
		this.firstName = entity.getFirstName();
		this.middleName = entity.getMiddleName();
		this.fullName = entity.getFirstName() + entity.getLastName() + entity.getMiddleName();
	}

}

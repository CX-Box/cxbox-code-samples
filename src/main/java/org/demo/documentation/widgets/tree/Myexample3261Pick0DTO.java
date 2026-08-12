package org.demo.documentation.widgets.tree;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.tree.tree.Myexample3261;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3261Pick0DTO extends DataResponseDTO {

	@SearchParameter(name = "department", provider = StringValueProvider.class)
	private String department;
	private Long parentId;
	private Boolean	isLeaf;

	public Myexample3261Pick0DTO(Myexample3261 entity) {
		this.id = entity.getId().toString();
		this.department = entity.getDepartment();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getIsLeaf();
	}

}

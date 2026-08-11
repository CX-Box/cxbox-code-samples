package org.demo.documentation.widgets.picktreepopup;

import java.lang.Long;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.widgets.picktreepopup.tree.Myexample3261;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3261PickDTO extends DataResponseDTO {

	@SearchParameter(name = "department")
	private String department;
	private Long parentId;
	private Boolean	isLeaf;

	public Myexample3261PickDTO(Myexample3261 entity) {
		this.id = entity.getId().toString();
		this.department = entity.getDepartment();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getIsLeaf();
	}

}

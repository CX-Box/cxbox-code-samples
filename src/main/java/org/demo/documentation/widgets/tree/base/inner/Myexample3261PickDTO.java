package org.demo.documentation.widgets.tree.base.inner;

import java.lang.Long;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3261PickDTO extends DataResponseDTO {

	@SearchParameter(name = "department")
	private String department;
	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;
	private Boolean isLeaf;

	@SearchParameter(name = "description")
	private String description;

	@SearchParameter(name = "code")
	private String code;

	@SearchParameter(name = "mnemonic")
	private String mnemonic;

	public Myexample3261PickDTO(Myexample3261 entity) {
		this.id = entity.getId().toString();
		this.department = entity.getDepartment();
		this.parentId = entity.getParentId();

		this.description = entity.getDescription();
		this.code = entity.getCode();
		this.mnemonic = entity.getMnemonic();
		this.isLeaf = entity.getChildren().isEmpty();
	}

}

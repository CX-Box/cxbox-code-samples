package org.demo.documentation.widgets.tree.base.inner;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3261Pick0DTO extends DataResponseDTO {

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

	public Myexample3261Pick0DTO(Myexample3261 entity) {
		this.id = entity.getId().toString();
		this.department = entity.getDepartment();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getParentId() == null ? false : true;
		this.description = entity.getDescription();
		this.code = entity.getCode();
		this.mnemonic = entity.getMnemonic();
	}

}

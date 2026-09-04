package org.demo.documentation.widgets.tree.base.inner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3261DTO extends DataResponseDTO {


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

	@SearchParameter(suppressProcess = true)
	private Boolean isIncluded;

	private String colorIncluded;

	public Myexample3261DTO(Myexample3261 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.department = entity.getDepartment();
		this.parentId = entity.getParentId();

		this.description = entity.getDescription();
		this.code = entity.getCode();
		this.mnemonic = entity.getMnemonic();
		this.isLeaf = entity.getChildren().isEmpty();
	}
}

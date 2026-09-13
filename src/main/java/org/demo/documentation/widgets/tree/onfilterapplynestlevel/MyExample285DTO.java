package org.demo.documentation.widgets.tree.onfilterapplynestlevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.tree.data.alltypes.Myexample3262;


@Getter
@Setter
@NoArgsConstructor
public class MyExample285DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;
	private Boolean isLeaf;

	public MyExample285DTO(Myexample3262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();

		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
	}
}

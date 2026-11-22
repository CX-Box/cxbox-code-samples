package org.demo.documentation.widgets.tree.fieldtitle;

import java.time.Year;
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
public class MyExample6166DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	// --8<-- [start:customFieldTitle]
	private String customFieldTitle;
	// --8<-- [end:customFieldTitle]

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	public MyExample6166DTO(Myexample3262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		// --8<-- [start:customFieldTitleValue]
		this.customFieldTitle = "Custom Field, " + Year.now();
		// --8<-- [end:customFieldTitleValue]
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
	}
}

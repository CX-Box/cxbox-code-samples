package org.demo.documentation.widgets.tree.base.customfields;

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
public class MyExample3278DTO extends DataResponseDTO {

	public static final String INFO_TEXT_CUSTOM_FIELDS = "Custom fields. Shows tree built by custom DTO fields mapped in widget options via parentFieldKey and isLeafFieldKey";

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long customFieldParentId;
	private Boolean customFieldIsLeaf;

	public MyExample3278DTO(Myexample3262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();

		this.customFieldParentId = entity.getParentId();
		this.customFieldIsLeaf = entity.getChildren().isEmpty();
	}
}

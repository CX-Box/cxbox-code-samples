package org.demo.documentation.other.forceactive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3204DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldFA")
	private String customFieldFA;
	@SearchParameter(name = "customFieldDrillDown")
	private String customFieldDrillDown;

	public MyExample3204DTO(MyEntity3204 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldFA = entity.getCustomFieldFA();
		this.customFieldDrillDown = entity.getCustomFieldDrillDown();
	}
}
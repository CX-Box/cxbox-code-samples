package org.demo.documentation.widgets.property.excel.postAction.base;

import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6500PostActionExportToExcelListDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;
	private String testData;

	public MyExample6500PostActionExportToExcelListDTO(MyExample6500PostActionExportToExcelListEntity entity) {
		this.id = Optional.ofNullable(entity.getId()).map(String::valueOf).orElse(null);
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.testData = entity.getTestData();
	}

}

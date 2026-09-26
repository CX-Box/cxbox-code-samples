package org.demo.documentation.widgets.pie1d.drilldown.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingData;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4219SaleDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	private Long customFieldNum;

	private LocalDateTime customFieldDate;

	public MyExample4219SaleDTO(MyEntityRingData entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNum = entity.getCustomFieldNum();
		this.customFieldDate = entity.getCustomFieldDate();
	}

}

package org.demo.documentation.feature.drilldown.drilldownkey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3627DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	// --8<-- [start:drillDownKey]
	// drill-down link of the record: a widget field takes it with "drillDownKey": "customFieldDrillDownKey"
	private String customFieldDrillDownKey;
	// --8<-- [end:drillDownKey]

	public MyExample3627DTO(MyEntity3627 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		// --8<-- [start:drillDownKeyValue]
		this.customFieldDrillDownKey = "/screen/myexample3627/view/myexample3627key/"
				+ CxboxMyExample3627Controller.myexample3627 + "/" + this.id;
		// --8<-- [end:drillDownKeyValue]
	}

}

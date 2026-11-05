package org.demo.documentation.widgets.relationGraph.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6158CompanyDTO extends DataResponseDTO {

	private String name;

	private String city;

	private Long sum;

	public MyExample6158CompanyDTO(MyEntity6151 entity) {
		this.id = entity.getId().toString();
		this.name = entity.getName();
		this.city = entity.getCity();
		this.sum = entity.getSum();
	}
}

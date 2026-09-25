package org.demo.documentation.widgets.line2d.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.line2d.data.MyEntity4240;
import org.demo.documentation.widgets.line2d.data.ProductEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4248ListDTO extends DataResponseDTO {

	@SearchParameter(name = "month", provider = LongValueProvider.class)
	private Long month;

	@SearchParameter(name = "clientName")
	private String clientName;

	@SearchParameter(name = "productName", provider = EnumValueProvider.class)
	private ProductEnum productName;

	@SearchParameter(name = "sum", provider = LongValueProvider.class)
	private Long sum;

	public MyExample4248ListDTO(MyEntity4240 entity) {
		this.id = entity.getId().toString();
		this.month = entity.getMonth();
		this.clientName = entity.getClientName();
		this.productName = entity.getProductName();
		this.sum = entity.getSum();
	}
}

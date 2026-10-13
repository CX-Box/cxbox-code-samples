package org.demo.documentation.widgets.column2d.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.column2d.data.MyEntity4252;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Product;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4258SaleDTO extends DataResponseDTO {

	@SearchParameter(name = "clientName")
	private String clientName;

	@SearchParameter(name = "product", provider = EnumValueProvider.class)
	private MyEntity4252Product product;

	@SearchParameter(name = "amount")
	private Long amount;

	public MyExample4258SaleDTO(MyEntity4252 entity) {
		this.id = entity.getId().toString();
		this.clientName = entity.getClientName();
		this.product = entity.getProduct();
		this.amount = entity.getAmount();
	}

}

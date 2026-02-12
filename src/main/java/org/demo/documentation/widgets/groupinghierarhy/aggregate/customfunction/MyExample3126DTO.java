package org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3126DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "location")
	private String location;
	@SearchParameter(name = "object")
	private String object;
	@SearchParameter(name = "insuranceValue", provider = BigDecimalValueProvider.class)
	private Long insuranceValue;
	@SearchParameter(name = "insuranceAmount", provider = BigDecimalValueProvider.class)
	private Long insuranceAmount;
	@SearchParameter(name = "netAnnualRate", provider = BigDecimalValueProvider.class)
	private Long netAnnualRate;
	private Float percentInsuranceAmount;

	public MyExample3126DTO(MyEntity3126 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.location = entity.getLocation();
		this.object = entity.getObject();
		this.insuranceValue = entity.getInsuranceValue();
		this.insuranceAmount = entity.getInsuranceAmount();
		this.netAnnualRate = entity.getNetAnnualRate();

	}

}
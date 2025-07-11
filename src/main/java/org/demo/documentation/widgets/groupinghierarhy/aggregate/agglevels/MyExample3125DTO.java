package org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3125DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "location")
    private String location;
    @SearchParameter(name = "object")
    private String object;
    @SearchParameter(name = "insuranceValue", provider = BigDecimalValueProvider.class)
    private Long insuranceValue;
    @SearchParameter(name = "insuranceAmount", provider = BigDecimalValueProvider.class)
    private Double insuranceAmount;
    @SearchParameter(name = "netAnnualRate", provider = BigDecimalValueProvider.class)
    private Double netAnnualRate;
    @SearchParameter(name = "acquisition", provider = BigDecimalValueProvider.class)
    private Double acquisition;
    @SearchParameter(name = "grossAnnualRate", provider = BigDecimalValueProvider.class)
    private Long grossAnnualRate;
    @SearchParameter(name = "annualPremium", provider = BigDecimalValueProvider.class)
    private Long annualPremium;
    @SearchParameter(name = "underinsurancePercentage", provider = BigDecimalValueProvider.class)
    private Long underinsurancePercentage;

    public MyExample3125DTO(MyEntity3125 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.location = entity.getLocation();
        this.object = entity.getObject();
        this.insuranceValue = entity.getInsuranceValue();
        this.insuranceAmount = entity.getInsuranceAmount();
        this.netAnnualRate = entity.getNetAnnualRate();
        this.acquisition = entity.getAcquisition();
        this.grossAnnualRate = entity.getGrossAnnualRate();
        this.annualPremium = entity.getAnnualPremium();
        this.underinsurancePercentage = entity.getUnderinsurancePercentage();
    }
}
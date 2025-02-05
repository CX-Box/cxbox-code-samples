package org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3125 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String location;
    @Column
    private String object;
    @Column
    private Long insuranceValue;
    @Column
    private Double insuranceAmount;
    @Column
    private Double netAnnualRate;
    @Column
    private Double acquisition;
    @Column
    private Long grossAnnualRate;
    @Column
    private Long annualPremium;
    @Column
    private Long underinsurancePercentage;
}
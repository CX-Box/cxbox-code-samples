package org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction;

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
public class MyEntity3126 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String location;
    @Column
    private String object;
    @Column
    private Long insuranceValue;
    @Column
    private Long insuranceAmount;
    @Column
    private Long netAnnualRate;
}
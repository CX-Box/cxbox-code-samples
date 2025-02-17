package org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3184 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private Boolean customFieldCheckbox = true;
}
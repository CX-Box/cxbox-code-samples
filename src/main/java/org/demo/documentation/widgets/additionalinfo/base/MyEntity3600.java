package org.demo.documentation.widgets.additionalinfo.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

// 3600
// 3600
//  AdditionalInfo widget basic",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3600 extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
    @Column
    private String customField3;
}
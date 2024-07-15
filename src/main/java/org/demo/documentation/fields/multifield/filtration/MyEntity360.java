package org.demo.documentation.fields.multifield.filtration;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity360 extends BaseEntity {

    @Column
    private String customFieldAdditional;
    @Column
    private String informationField;
    @Column
    private String customField;
    @Column
    private String customFieldAdditionalMulti;
    @Column
    private String customFieldMulti;
}
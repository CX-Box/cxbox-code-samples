package org.demo.documentation.fields.checkbox.basic;

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
public class MyEntity82 extends BaseEntity {

    @Column
    private Boolean customField;

    @Column
    private String dsgfsg;

    @Column
    private Boolean customField5;

    @Column
    private String customField4;

    @Column
    private String customField6;

    @Column
    private Boolean customField2;

    @Column
    private String customField3;

    @Column
    private Boolean customField7;

    @Column
    private String customField8;

    @Column
    private Boolean customField9;

    @Column
    private Boolean customField10;

    @Column
    private Boolean customField11;
}
package org.demo.documentation.widgets.form.showcondition.bycurrententity;

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
public class MyEntity3005 extends BaseEntity {

    @Column
    private Long customField;

    @Column
    private String customField3;

    @Column
    private String customField2;
}
package org.demo.documentation.widgets.formpopup.base.onefield;

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
public class MyEntity3400 extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
}
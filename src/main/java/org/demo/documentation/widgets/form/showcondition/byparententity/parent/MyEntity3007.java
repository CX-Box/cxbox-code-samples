package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3007 extends BaseEntity {

    @Column
    private Boolean customFieldShowCondition;
    @Column
    private Long customField;
}
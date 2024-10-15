package org.demo.documentation.widgets.list.showcondition.byparententity.parent;

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
public class MyEntity3100 extends BaseEntity {

    @Column
    private String customField;

    @Column
    private Long customFieldNumber= 0L;

    @Column
    private Boolean customFieldShowCondition;

}
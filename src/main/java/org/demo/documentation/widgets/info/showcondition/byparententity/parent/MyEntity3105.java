package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

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
public class MyEntity3105 extends BaseEntity {
    @Column
    private Boolean customFieldShowCondition;
    @Column
    private Long customField;
}
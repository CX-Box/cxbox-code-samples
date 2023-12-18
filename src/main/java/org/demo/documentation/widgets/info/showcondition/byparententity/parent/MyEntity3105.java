package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

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
public class MyEntity3105 extends BaseEntity {
    @Column
    private String customFieldShowCondition;
    @Column
    private String customField3;

    @Column
    private String customField4;
    @Column
    private Long customField;
}
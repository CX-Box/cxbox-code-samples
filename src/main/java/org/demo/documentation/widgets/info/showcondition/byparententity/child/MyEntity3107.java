package org.demo.documentation.widgets.info.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.info.showcondition.byparententity.parent.MyEntity3105;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3107 extends BaseEntity {

    @Column
    private Long customField;
    @Column
    private String customField2;
    @Column
    private String customField3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3105 customFieldEntity;
}
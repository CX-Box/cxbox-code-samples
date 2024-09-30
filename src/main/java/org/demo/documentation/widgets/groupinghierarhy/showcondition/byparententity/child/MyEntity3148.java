package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyEntity3149;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3148 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3149 customFieldEntity;
}

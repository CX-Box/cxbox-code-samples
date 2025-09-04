package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent.MyEntity5036;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5037 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity5036 customFieldEntity;
}

package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyEntity3106;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyEntity3146;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3145 extends BaseEntity {

    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3146 customFieldEntity;

    @JoinColumn(name = "FGDFGD_ID")
    @ManyToOne
    private MyEntity3106 fgdfgdEntity;
}
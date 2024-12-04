package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyEntity3169;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3170 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3169 customFieldEntity;
}
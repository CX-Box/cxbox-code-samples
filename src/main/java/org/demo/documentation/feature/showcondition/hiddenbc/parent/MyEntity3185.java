package org.demo.documentation.feature.showcondition.hiddenbc.parent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.showcondition.hiddenbc.mainbc.MyEntity3184;
import org.demo.documentation.feature.showcondition.twobcshowcondition.parent.MyEntity3146;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3185 extends BaseEntity {
    @Column
    private String customField;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3184 customFieldEntity;
    @Column
    private Boolean customFieldCheckbox = false;
}
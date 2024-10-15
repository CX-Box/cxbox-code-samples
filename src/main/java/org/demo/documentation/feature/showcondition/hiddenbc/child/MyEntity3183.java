package org.demo.documentation.feature.showcondition.hiddenbc.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.showcondition.hiddenbc.parent.MyEntity3185;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3183 extends BaseEntity {
    @Column
    private String customField;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3185 customFieldEntity;
}
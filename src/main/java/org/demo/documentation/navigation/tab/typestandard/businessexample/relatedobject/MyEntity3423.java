package org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.typestandard.businessexample.MyEntity3422;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3423 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3422 customFieldEntity;
}
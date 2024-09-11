package org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyEntity3428;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3427 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3428 customFieldEntity;
}
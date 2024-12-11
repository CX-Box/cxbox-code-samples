package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.MyEntity3238;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3239 extends BaseEntity {
    @Column
    private String customField;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3238 customFieldEntity;
    @Column
    private String fullName;
    @Column
    private String phoneNumber;
}
package org.demo.documentation.navigation.tab.other.example5.child4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3165 extends BaseEntity {
    @Column
    private String customField;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3163 customFieldEntity;
}
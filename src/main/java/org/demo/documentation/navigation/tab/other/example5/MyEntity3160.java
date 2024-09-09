package org.demo.documentation.navigation.tab.other.example5;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3160 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3161 customFieldEntity;
}
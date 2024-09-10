package org.demo.documentation.navigation.tab.other.example2.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.other.example2.MyEntity3422;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3425 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3422 customFieldEntity;
}
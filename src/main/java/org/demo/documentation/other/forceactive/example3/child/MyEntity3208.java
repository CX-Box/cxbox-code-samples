package org.demo.documentation.other.forceactive.example3.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.forceactive.example3.MyEntity3207;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3208 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3207 customFieldEntity;

}
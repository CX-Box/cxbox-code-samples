package org.demo.documentation.other.savewithparent.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.parent.MyEntity3058;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3057 extends BaseEntity {
    @Column
    private String customField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3058 customFieldEntity;
}
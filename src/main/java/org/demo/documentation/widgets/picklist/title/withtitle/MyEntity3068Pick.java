package org.demo.documentation.widgets.picklist.title.withtitle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3068Pick extends BaseEntity {
    @Column
    private String customFieldPick;
}
package org.demo.documentation.widgets.property.filtration.filtergroup.forassoc;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3623 extends BaseEntity {
    @Column
    private String customField;
}
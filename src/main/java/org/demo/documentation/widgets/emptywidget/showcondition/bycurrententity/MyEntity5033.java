package org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity;

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
public class MyEntity5033 extends BaseEntity {
    @Column
    private Long customField = 0L;
}

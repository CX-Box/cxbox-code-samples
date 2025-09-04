package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent;

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
public class MyEntity5036 extends BaseEntity {
    @Column
    private Long customField = 0L;
}

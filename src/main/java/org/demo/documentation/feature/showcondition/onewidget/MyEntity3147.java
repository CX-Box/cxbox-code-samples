package org.demo.documentation.feature.showcondition.onewidget;

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
public class MyEntity3147 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private Long customFieldNumber = 0L;
}
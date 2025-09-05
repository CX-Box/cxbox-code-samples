package org.demo.documentation.widgets.steps.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5023 extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    private StepsEnum editStep = StepsEnum.STEP_1;

}

package org.demo.documentation.feature.postaction.waituntil;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.postaction.enums.StatusEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3231 extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    @Column
    private StatusEnum statusResponse = StatusEnum.NEW;

    @Column
    private String customFieldForm;
}
package org.demo.documentation.feature.synchasyncrequests.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class MyEntity3231Queue extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    @Column
    private StatusEnum2 customFieldDictionary;

    @Column
    private String entityId;
}
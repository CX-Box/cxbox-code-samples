package org.demo.documentation.feature.synchasyncrequests;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3231Queue extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    @Column
    private StatusEnum customFieldDictionary;

    @Column
    private String entityId;
}
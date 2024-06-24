package org.demo.documentation.feature.drilldown.advancedonebcfilter;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.enums.CustomFieldFilterDictionaryEnum;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3612 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private LocalDateTime customFieldFilterDate;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldFilterDictionaryEnum customFieldFilterDictionary;
}
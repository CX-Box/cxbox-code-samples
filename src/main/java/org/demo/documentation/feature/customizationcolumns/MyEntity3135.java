package org.demo.documentation.feature.customizationcolumns;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldDictionaryEnum;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3135 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldInput;
    @Column
    private LocalDateTime customFieldDate;
    @Column
    private Boolean customFieldCheckBox;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
}
package org.demo.documentation.fields.dictionary.icon;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3011 extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
}
package org.demo.documentation.widgets.additionallist.colortitle.twofields;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.additionallist.colortitle.twofields.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3196 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldText;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
}
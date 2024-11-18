package org.demo.documentation.widgets.groupinghierarhy.sorting;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.sorting.enums.CustomFieldDictionaryEnum;


// 3176
// 3176
// 3176

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3176 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
}
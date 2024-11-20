package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3203 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
}
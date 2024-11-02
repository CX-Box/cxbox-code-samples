package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelFourEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelTwoEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3155 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryLevelFourEnum customFieldDictionaryLevelFour;
}
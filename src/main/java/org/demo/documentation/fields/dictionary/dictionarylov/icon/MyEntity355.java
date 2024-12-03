package org.demo.documentation.fields.dictionary.dictionarylov.icon;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.dictionarylov.basic.Regions;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity355 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private CustomDictionary customFieldDictionary;
}
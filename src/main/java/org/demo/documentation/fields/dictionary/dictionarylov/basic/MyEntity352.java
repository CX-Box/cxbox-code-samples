package org.demo.documentation.fields.dictionary.dictionarylov.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.dictionarylov.DictinaryLovRegion;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity352 extends BaseEntity {
    @Column
    private String customField;

    @Column
    private DictinaryLovRegion customFieldLov;
}
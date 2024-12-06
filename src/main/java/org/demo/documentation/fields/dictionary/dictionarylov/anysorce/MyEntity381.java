package org.demo.documentation.fields.dictionary.dictionarylov.anysorce;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity381 extends BaseEntity {
    @Column
    private DictionaryType customField;
}
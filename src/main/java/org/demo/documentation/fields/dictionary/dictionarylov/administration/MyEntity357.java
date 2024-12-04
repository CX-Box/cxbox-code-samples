package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity357 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "TYPE_ID")
    @ManyToOne
    private DictionaryTypeDesc typeEntity;
    @Column
    private String key;
    @Column
    private String value;
    @Column
    private Long displayOrder;
    @Column
    private String description;
    @Column
    private Boolean active;
}
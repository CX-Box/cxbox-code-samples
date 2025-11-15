package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.enums.CustomFieldEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5010 extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldEnum customField;

    @Column
    private String customFieldHidden;
}

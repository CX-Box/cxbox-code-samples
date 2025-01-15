package org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3624 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldNew;
}
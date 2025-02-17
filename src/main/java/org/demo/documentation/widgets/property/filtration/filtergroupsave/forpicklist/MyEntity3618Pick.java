package org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3618Pick extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldNew;

}
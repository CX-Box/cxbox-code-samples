package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3869 extends BaseEntity {
    @Column
    private String customField;

    @Column
    private String anySourceId;

}
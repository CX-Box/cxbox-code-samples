package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.showcondition.hiddenbc.parent.MyEntity3185;
import org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.MyEntity3861ForPickListpopupOutServiceDTO;

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
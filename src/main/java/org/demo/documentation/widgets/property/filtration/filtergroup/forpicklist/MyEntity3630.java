package org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3630 extends BaseEntity {
    @Column
    private String customField;

}
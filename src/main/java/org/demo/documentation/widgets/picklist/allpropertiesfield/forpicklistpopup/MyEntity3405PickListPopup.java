package org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3405PickListPopup extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldColorSort;
    @Column
    private String customFieldRequired;
    @Column
    private String customFieldColorValidation;
    @Column
    private String customFieldDrilldown;
    @Column
    private Long customFieldColorConst;
    @Column
    private Long customFieldColor;
    @Column
    private String customFieldPlaceholder;
}
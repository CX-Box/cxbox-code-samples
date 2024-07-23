package org.demo.documentation.widgets.picklist.color;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3060 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
    @ManyToOne
    private MyEntity3061 customFieldPicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICKLIST_COLOR_CONST_ID")
    @ManyToOne
    private MyEntity3061Pick customFieldPicklistColorConstEntity;
}
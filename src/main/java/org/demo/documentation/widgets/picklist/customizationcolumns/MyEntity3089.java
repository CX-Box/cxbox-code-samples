package org.demo.documentation.widgets.picklist.customizationcolumns;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3089 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
    @ManyToOne
    private MyEntity3089Pick customFieldPicklistEntity;
}
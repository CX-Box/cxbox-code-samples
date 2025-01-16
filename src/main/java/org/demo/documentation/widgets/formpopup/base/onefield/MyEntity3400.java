package org.demo.documentation.widgets.formpopup.base.onefield;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.MyEntity3400InlinePicklist;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3400 extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3400InlinePicklist customFieldInlinePicklistEntity;
    @Column
    private String customFieldRequired;
}
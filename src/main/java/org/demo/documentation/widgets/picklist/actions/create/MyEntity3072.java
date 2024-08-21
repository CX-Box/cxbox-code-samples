package org.demo.documentation.widgets.picklist.actions.create;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.actions.create.inlinepicklist.MyEntity3072InlinePick;
import org.demo.documentation.widgets.picklist.actions.create.picklist.MyEntity3072Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3072 extends BaseEntity {

    @JoinColumn(name = "CUSTOM_FIELD_ID")
    @ManyToOne
    private MyEntity3072Pick customFieldEntity;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3072InlinePick customFieldInlinePicklistEntity;
}
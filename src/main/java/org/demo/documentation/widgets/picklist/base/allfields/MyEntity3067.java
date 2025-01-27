package org.demo.documentation.widgets.picklist.base.allfields;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067 extends BaseEntity {

    @JoinColumn(name = "CUSTOM_FIELD_ID")
    @ManyToOne
    private MyEntity3067Pick customFieldEntity;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3067Pick customFieldInlinePickListEntity;
}
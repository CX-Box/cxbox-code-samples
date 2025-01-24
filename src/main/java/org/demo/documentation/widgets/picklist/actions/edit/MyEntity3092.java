package org.demo.documentation.widgets.picklist.actions.edit;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;


// 3092
// 3092
// 3092

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3092 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3092Pick customFieldPickListEntity;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3092Pick customFieldInlinePickListEntity;
}
package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel.MyEntity3198PickOnCancel;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.postaction.MyEntity3198PickPostAction;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3198 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3198Pick customFieldPickListEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ON_CANCEL_ID")
    @ManyToOne
    private MyEntity3198PickOnCancel customFieldPickListOnCancelEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_POST_ACTION_ID")
    @ManyToOne
    private MyEntity3198PickPostAction customFieldPickListPostActionEntity;
}
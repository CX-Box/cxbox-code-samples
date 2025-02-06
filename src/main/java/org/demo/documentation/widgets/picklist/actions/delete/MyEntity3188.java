package org.demo.documentation.widgets.picklist.actions.delete;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup.MyEntity3188Pick;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3188 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_DELETE_ID")
    @ManyToOne
    private MyEntity3188Pick customFieldDeleteEntity;
}
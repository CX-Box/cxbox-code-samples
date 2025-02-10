package org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel;

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
public class MyEntity3198PickOnCancel extends BaseEntity {
    @Column
    private String customField;
}
package org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup;

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
public class MyEntity3188Pick extends BaseEntity {
    @Column
    private String customField;
}
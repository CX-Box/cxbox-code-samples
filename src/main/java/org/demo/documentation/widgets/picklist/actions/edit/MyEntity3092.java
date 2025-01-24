package org.demo.documentation.widgets.picklist.actions.edit;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


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
}
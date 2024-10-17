package org.demo.documentation.widgets.form.actions.cancelcreate.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3182
// 3182
// 3182

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3182 extends BaseEntity {
    @Column
    private String customField;
}
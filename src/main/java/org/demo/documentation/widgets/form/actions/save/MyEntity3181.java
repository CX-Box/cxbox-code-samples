package org.demo.documentation.widgets.form.actions.save;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3181
// 3181
// 3181

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3181 extends BaseEntity {
    @Column
    private String customField;
}
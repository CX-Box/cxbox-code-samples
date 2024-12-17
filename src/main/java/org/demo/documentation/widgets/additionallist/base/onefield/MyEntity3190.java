package org.demo.documentation.widgets.additionallist.base.onefield;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3190
// 3190
// 3190

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3190 extends BaseEntity {
    @Column
    private String customField;
}
package org.demo.documentation.widgets.formpopup.colortitle;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3027
// 3027
// 3027

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3027 extends BaseEntity {
    @Column
    private String customField;
}
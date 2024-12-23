package org.demo.documentation.widgets.additionallist.title;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3195 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldText;
}
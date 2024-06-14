package org.demo.documentation.widgets.statsblock.base.data;

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
public class MyEntity4201 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private Integer customFieldNum = 0;
}
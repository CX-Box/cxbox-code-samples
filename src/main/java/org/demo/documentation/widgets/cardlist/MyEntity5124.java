package org.demo.documentation.widgets.cardlist;

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
public class MyEntity5124 extends BaseEntity {
    @Column
    private String customField;

    @Column
    private String customFieldFile;

    @Column
    private String customFieldFileId;
}

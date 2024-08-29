package org.demo.documentation.other.savewithparent.example1;

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
public class MyEntity3132 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customField2;
    @Column
    private String customField3;
    @Column
    private String customFieldInfo;
}
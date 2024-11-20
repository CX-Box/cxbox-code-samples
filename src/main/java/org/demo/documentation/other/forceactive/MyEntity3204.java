package org.demo.documentation.other.forceactive;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3204
// 3204
// 3204

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3204 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldFA;
    @Column
    private String customFieldDrillDown;
}
package org.demo.documentation.widgets.property.excel.filtration;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3138 extends BaseEntity {

    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private Long customFieldNumber;
    @Column
    private String customFieldInput;
    @Column
    private String customFieldText;
}
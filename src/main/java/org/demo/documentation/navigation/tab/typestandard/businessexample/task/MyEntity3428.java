package org.demo.documentation.navigation.tab.typestandard.businessexample.task;

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
public class MyEntity3428 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldDrilldown;


    @Column
    private String customFieldAdditional;
    @Column
    private LocalDateTime meetDate;
}
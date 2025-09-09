package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4216 extends BaseEntity {
    @Column
    private String customField;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ExampleStatus status;
}

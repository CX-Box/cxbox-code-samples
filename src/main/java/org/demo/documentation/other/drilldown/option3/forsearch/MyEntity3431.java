package org.demo.documentation.other.drilldown.option3.forsearch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.io.Serial;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3431 extends BaseEntity {
    @Column
    private String customField;

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;

}
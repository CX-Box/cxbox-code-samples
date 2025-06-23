package org.demo.documentation.other.forceactive2.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4902Suggection extends BaseEntity {
    @Column
    private String customField;
}

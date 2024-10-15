package org.demo.documentation.feature.showcondition.twobcshowcondition.parent;

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
public class MyEntity3146 extends BaseEntity {
    @Column
    private Long customField = 0L;


}
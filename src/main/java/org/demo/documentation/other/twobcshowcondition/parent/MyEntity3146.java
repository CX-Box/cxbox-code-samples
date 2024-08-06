package org.demo.documentation.other.twobcshowcondition.parent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.twobcshowcondition.child.MyEntity3145;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3146 extends BaseEntity {
    @Column
    private Long customField = 0L;


}
package org.demo.documentation.time.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

// 3507
// 6009
//  Time readonly",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3507 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}
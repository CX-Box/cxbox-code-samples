package org.demo.documentation.widgets.formpopup.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

// 3401
// 3000
//  Title",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3401 extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
}
package org.demo.documentation.widgets.form.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3003 extends BaseEntity {

    @Column
    private String customField;

    @Column
    private String customField2;
}
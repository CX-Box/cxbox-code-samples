package org.demo.documentation.widgets.formpopup.base.onefield.forfields;

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
public class MyEntity3400InlinePicklist extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
}
package org.demo.documentation.widgets.assoc.actions.other.createwithparent.assocreq;

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
public class MyEntity3663 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldText;
}
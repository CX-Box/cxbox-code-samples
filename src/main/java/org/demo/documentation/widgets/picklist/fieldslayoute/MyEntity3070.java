package org.demo.documentation.widgets.picklist.fieldslayoute;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3070 extends BaseEntity {

    @JoinColumn(name = "CUSTOM_FIELD_ID")
    @ManyToOne
    private MyEntity3070Pick customFieldEntity;
}
package org.demo.documentation.widgets.picklist.title;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.basic.MyEntity3067Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3068 extends BaseEntity {


    @JoinColumn(name = "CUSTOM_FIELD_ID")
    @ManyToOne
    private MyEntity3068Pick customFieldEntity;
}
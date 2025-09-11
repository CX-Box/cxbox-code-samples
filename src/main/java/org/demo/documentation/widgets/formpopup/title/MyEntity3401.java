package org.demo.documentation.widgets.formpopup.title;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.demo.documentation.fields.percent.validationbusinessex.MyEntity10;

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

    @JoinColumn(name = "FGHGF_ID")
    @ManyToOne
    private MyEntity10 fghgfEntity;
}
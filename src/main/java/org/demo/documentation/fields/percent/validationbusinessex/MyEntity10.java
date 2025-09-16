package org.demo.documentation.fields.percent.validationbusinessex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.fileupload.required.MyEntity101;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity10 extends BaseEntity {

    @Column
    private Long customField;

    @Column
    private String customFieldText;

    @JoinColumn(name = "DFGDFGD_ID")
    @ManyToOne
    private MyEntity101 dfgdfgdEntity;
}
package org.demo.documentation.navigation.tab.typestandard;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.fileupload.validationbusinessex.MyEntity103;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3235 extends BaseEntity {
    @Column
    private String customField;

    @JoinColumn(name = "DSDFS_ID")
    @ManyToOne
    private MyEntity103 dsdfsEntity;
}
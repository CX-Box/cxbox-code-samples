package org.demo.documentation.widgets.list.edit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3700 extends BaseEntity {

    @Column
    private String customField;
}
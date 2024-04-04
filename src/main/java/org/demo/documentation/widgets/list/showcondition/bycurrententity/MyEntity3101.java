package org.demo.documentation.widgets.list.showcondition.bycurrententity;

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
public class MyEntity3101 extends BaseEntity {

    @Column
    private Long customField;

}
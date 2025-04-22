package org.demo.documentation.fields.time.validationannotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4102 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}
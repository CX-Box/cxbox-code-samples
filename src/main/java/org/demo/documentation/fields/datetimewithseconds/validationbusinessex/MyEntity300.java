package org.demo.documentation.fields.datetimewithseconds.validationbusinessex;

import org.cxbox.model.core.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity300 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}
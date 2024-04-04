package org.demo.documentation.time.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3505 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}
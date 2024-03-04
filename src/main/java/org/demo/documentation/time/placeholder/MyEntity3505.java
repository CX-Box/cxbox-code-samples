package org.demo.documentation.time.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3505 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}
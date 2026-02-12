package org.demo.documentation.fields.date.colorconst;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "dateColorConstEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateColorConstEntity extends BaseEntity {

	private LocalDateTime customField;

}
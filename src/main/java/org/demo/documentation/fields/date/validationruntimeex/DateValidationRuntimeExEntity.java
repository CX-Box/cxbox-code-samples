package org.demo.documentation.fields.date.validationruntimeex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DateValidationRuntimeExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationRuntimeExEntity extends BaseEntity {

	private LocalDateTime customField;

}
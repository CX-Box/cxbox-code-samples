package org.demo.documentation.fields.date.validationruntimeex;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateValidationRuntimeExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationRuntimeExEntity extends BaseEntity {

	private LocalDateTime  customField;

}
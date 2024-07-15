package org.demo.documentation.fields.datetimewithseconds.validationruntimeex;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsValidationRuntimeExEntity
@Entity
@Table(name = "DateTimeWithSecondsValidationRuntimeExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsValidationRuntimeExEntity extends BaseEntity {

	private LocalDateTime customField;

}
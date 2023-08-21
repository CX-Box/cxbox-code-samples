package org.demo.documentation.dateytimewithseconds.validationruntimeex;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
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
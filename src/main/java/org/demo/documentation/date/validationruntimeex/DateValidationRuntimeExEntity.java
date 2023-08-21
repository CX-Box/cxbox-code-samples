package org.demo.documentation.date.validationruntimeex;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateValidationRuntimeExEntity
@Entity
@Table(name = "DateValidationRuntimeExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationRuntimeExEntity extends BaseEntity {

	private LocalDate customField;

}
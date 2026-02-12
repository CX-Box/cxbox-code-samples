package org.demo.documentation.fields.datetime.validationruntimeex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeValidationRuntimeEx
@Entity
@Table(name = "DateTimeValidationRuntimeEx")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidationRuntimeEx extends BaseEntity {

	private LocalDateTime customField;

}
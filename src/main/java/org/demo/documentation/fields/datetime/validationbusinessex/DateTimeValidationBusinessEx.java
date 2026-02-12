package org.demo.documentation.fields.datetime.validationbusinessex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeValidationBusinessEx
@Entity
@Table(name = "DateTimeValidationBusinessEx")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidationBusinessEx extends BaseEntity {

	private LocalDateTime customField;

}
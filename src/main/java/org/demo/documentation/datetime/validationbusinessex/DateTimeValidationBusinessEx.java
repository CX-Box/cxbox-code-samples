package org.demo.documentation.datetime.validationbusinessex;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeValidationBusinessEx
@Entity
@Table(name = "DateTimeValidationBusinessEx")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidationBusinessEx extends BaseEntity {

	private LocalDateTime customField;

}
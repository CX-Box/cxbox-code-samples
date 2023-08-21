package org.demo.documentation.date.validationbusinessex;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateValidationBusinessEx
@Entity
@Table(name = "DateValidationBusinessExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationBusinessExEntity extends BaseEntity {

	private LocalDate customField;

}
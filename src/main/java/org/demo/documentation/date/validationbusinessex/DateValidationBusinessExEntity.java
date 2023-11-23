package org.demo.documentation.date.validationbusinessex;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateValidationBusinessExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationBusinessExEntity extends BaseEntity {

	private LocalDateTime  customField;

}
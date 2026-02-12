package org.demo.documentation.fields.date.validationbusinessex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DateValidationBusinessExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateValidationBusinessExEntity extends BaseEntity {

	private LocalDateTime customField;

}
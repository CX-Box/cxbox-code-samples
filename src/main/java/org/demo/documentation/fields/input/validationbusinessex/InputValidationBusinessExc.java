package org.demo.documentation.fields.input.validationbusinessex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "InputValidationBusinessException")
@Getter
@Setter
@NoArgsConstructor
public class InputValidationBusinessExc extends BaseEntity {

	private String customField;

}
package org.demo.documentation.input.validationbusinessex;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputValidationBusinessException
@Entity
@Table(name = "InputValidationBusinessException")
@Getter
@Setter
@NoArgsConstructor
public class InputValidationBusinessExc extends BaseEntity {

	private String customField;

}
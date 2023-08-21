package org.demo.documentation.input.validationruntimeex;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputValidationRuntimeException
@Entity
@Table(name = "InputValidationRuntimeException")
@Getter
@Setter
@NoArgsConstructor
public class InputValidationRuntimeException extends BaseEntity {

	private String customField;

}
package org.demo.documentation.input.validation;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputValidation
@Entity
@Table(name = "InputValidation")
@Getter
@Setter
@NoArgsConstructor
public class InputValidation extends BaseEntity {

	private String customField;

}

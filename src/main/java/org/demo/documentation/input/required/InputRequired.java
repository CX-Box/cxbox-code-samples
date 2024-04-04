package org.demo.documentation.input.required;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputRequired
@Entity
@Table(name = "InputRequired")
@Getter
@Setter
@NoArgsConstructor
public class InputRequired extends BaseEntity {

	private String customField;

}
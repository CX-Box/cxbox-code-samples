package org.demo.documentation.input.color;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputColor
@Entity
@Table(name = "InputColor")
@Getter
@Setter
@NoArgsConstructor
public class InputColor extends BaseEntity {

	private String customField;

}

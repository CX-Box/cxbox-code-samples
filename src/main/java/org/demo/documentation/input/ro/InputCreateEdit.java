package org.demo.documentation.input.ro;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputCreateEdit
@Entity
@Table(name = "InputCreateEdit")
@Getter
@Setter
@NoArgsConstructor
public class InputCreateEdit extends BaseEntity {

	private String customField;

}

package org.demo.documentation.input.ro;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

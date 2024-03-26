package org.demo.documentation.input.colorconst;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputColorConst
@Entity
@Table(name = "InputColorConst")
@Getter
@Setter
@NoArgsConstructor
public class InputColorConst extends BaseEntity {

	private String customField;

}
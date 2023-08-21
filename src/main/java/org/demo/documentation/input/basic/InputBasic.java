package org.demo.documentation.input.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputBasic
@Entity
@Table(name = "InputBasic")
@Getter
@Setter
@NoArgsConstructor
public class InputBasic extends BaseEntity {

	private String customField;

	@Column
	private String customFieldRO;

}

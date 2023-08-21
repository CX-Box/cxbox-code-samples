package org.demo.documentation.multivalue.validationannotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity199 extends BaseEntity {

	@Column
	private String customField;

}
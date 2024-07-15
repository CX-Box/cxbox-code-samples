package org.demo.documentation.fields.input.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


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

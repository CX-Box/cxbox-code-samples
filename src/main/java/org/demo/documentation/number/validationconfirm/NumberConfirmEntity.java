package org.demo.documentation.number.validationconfirm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberConfirm
@Entity
@Table(name = "NumberConfirmEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberConfirmEntity extends BaseEntity {


	@Column
	private Long customField;

}
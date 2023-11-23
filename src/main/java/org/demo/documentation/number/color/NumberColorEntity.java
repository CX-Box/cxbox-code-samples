package org.demo.documentation.number.color;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberColor
@Entity
@Table(name = "NumberColorEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberColorEntity extends BaseEntity {


	@Column
	private Long customField;

}
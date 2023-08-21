package org.demo.documentation.number.placeholder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberPlaceholder
@Entity
@Table(name = "NumberPlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberPlaceholderEntity extends BaseEntity {


	@Column
	private Long customField;

}
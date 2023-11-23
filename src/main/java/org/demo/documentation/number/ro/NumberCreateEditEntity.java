package org.demo.documentation.number.ro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberCreateEdit
@Entity
@Table(name = "NumberCreateEditEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberCreateEditEntity extends BaseEntity {


	@Column
	private Long customField;

}
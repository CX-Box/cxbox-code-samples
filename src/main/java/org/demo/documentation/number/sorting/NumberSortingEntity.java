package org.demo.documentation.number.sorting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberSorting
@Entity
@Table(name = "NumberSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberSortingEntity extends BaseEntity {


	@Column
	private Long customField;

}
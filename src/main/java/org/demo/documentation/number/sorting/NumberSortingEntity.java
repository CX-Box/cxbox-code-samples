package org.demo.documentation.number.sorting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
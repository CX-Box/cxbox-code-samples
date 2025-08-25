package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "MY_EXAMPLE3250_MULTIVALUE")
@NoArgsConstructor
@SuperBuilder
public class MyExample3250Multivalue extends BaseEntity {

	@Column
	public String name;

}
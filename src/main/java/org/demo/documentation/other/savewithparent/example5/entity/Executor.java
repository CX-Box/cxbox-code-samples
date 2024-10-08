package org.demo.documentation.other.savewithparent.example5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Executor extends BaseEntity {

	@Column
	private String name;

	@Column
	private String role;
}

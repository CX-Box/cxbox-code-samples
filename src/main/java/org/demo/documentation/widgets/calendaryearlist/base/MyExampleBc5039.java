package org.demo.documentation.widgets.calendaryearlist.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "MY_EXAMPLE_BC5039")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class MyExampleBc5039 extends BaseEntity {


	@Column
	private String customField;

	@Column
	private LocalDateTime startDateTime;

	@Column
	private LocalDateTime endDateTime;
}
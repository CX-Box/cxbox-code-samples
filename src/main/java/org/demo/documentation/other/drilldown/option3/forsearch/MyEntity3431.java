package org.demo.documentation.other.drilldown.option3.forsearch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.io.Serial;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3431 extends BaseEntity {
	@Serial
	private static final long serialVersionUID = 1L;
	@Column
	private String customField;
	private Long userId;

}
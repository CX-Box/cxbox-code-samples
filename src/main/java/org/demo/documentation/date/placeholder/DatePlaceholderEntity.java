package org.demo.documentation.date.placeholder;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;



@Entity
@Table(name = "DatePlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DatePlaceholderEntity extends BaseEntity {


	@Column
	private LocalDateTime  customField;

}
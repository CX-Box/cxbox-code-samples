package org.demo.documentation.fields.date.placeholder;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
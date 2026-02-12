package org.demo.documentation.fields.date.placeholder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DatePlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DatePlaceholderEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}
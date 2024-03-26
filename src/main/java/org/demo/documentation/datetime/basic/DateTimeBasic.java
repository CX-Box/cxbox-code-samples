package org.demo.documentation.datetime.basic;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateTimeBasic")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeBasic extends BaseEntity {

	private LocalDateTime customField;

}
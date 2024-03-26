package org.demo.documentation.date.basic;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;



@Entity
@Table(name = "DateBasic")
@Getter
@Setter
@NoArgsConstructor
public class DateBasic extends BaseEntity {

	private LocalDateTime customField;

}
package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@EqualsAndHashCode.Exclude
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@EqualsAndHashCode.Exclude
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

}

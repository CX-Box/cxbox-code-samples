package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyEntity4002External extends BaseEntity {

	private String customField;
	private String customFieldNew;
	private LocalDateTime customFieldDateTime;

	/** The tree tab: the parent record, empty for a root record. */
	private Long parentId;
}
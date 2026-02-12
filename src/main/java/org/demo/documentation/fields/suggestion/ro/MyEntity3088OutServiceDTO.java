package org.demo.documentation.fields.suggestion.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3088OutServiceDTO implements Serializable {

	private String id;
	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;
}
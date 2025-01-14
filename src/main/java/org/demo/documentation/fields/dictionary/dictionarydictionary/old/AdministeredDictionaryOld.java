package org.demo.documentation.fields.dictionary.dictionarydictionary.old;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.cxbox.api.data.dictionary.BaseLov;

@Target(FIELD)
@Retention(RUNTIME)
@BaseLov(type = AdministeredDictionaryTypeOld.class)
public @interface AdministeredDictionaryOld {

	AdministeredDictionaryTypeOld value();

}

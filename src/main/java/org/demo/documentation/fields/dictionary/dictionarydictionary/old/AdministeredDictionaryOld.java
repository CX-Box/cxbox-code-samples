package org.demo.documentation.fields.dictionary.dictionarydictionary.old;

import org.cxbox.api.data.dictionary.BaseLov;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@BaseLov(type = AdministeredDictionaryTypeOld.class)
public @interface AdministeredDictionaryOld {

	AdministeredDictionaryTypeOld value();

}

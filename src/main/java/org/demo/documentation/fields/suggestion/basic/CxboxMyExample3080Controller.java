package org.demo.documentation.fields.suggestion.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.basic.listvalues.MyExample4601Service;
import org.demo.documentation.fields.suggestion.basic.microservice.forfield.MyExample3091Service;
import org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield.MyExample4600Service;
import org.demo.documentation.fields.suggestion.basic.microservice.MyExample3080SuggestionService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3080Controller implements EnumBcIdentifier {

    myexample4601(MyExample4601Service.class),
    myexample4600(MyExample4600Service.class),
    myexample3091(MyExample3091Service.class),
    myexample3080(MyExample3080SuggestionService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3080Controller> Holder = new Holder<>(
            CxboxMyExample3080Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3080Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3080Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3080Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3080Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3080Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3080Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3080Controller> {

        public BcSupplier() {
            super(CxboxMyExample3080Controller.Holder);
        }

    }

}
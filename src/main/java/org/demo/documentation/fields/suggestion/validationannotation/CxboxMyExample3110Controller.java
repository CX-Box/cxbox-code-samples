package org.demo.documentation.fields.suggestion.validationannotation;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.validationannotation.forfield.MyExample3111Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3110Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3110(MyExample3110SuggestionService.class),
    myexample3111(MyExample3111Service.class);


    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3110Controller> Holder = new Holder<>(
            CxboxMyExample3110Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3110Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3110Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3110Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3110Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3110Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3110Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3110Controller> {

        public BcSupplier() {
            super(CxboxMyExample3110Controller.Holder);
        }

    }

}
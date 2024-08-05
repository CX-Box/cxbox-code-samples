package org.demo.documentation.fields.suggestion.ro;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.ro.forfield.MyExample3099Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3088Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3088(MyExample3088SuggestionService.class),
    myexample3099(MyExample3099Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3088Controller> Holder = new Holder<>(
            CxboxMyExample3088Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3088Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3088Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3088Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3088Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3088Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3088Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3088Controller> {

        public BcSupplier() {
            super(CxboxMyExample3088Controller.Holder);
        }

    }

}
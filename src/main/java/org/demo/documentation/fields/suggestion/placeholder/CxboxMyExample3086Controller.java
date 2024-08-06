package org.demo.documentation.fields.suggestion.placeholder;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.placeholder.forfield.MyExample3097Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3086Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3086(MyExample3086SuggestionService.class),
    myexample3097(MyExample3097Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3086Controller> Holder = new Holder<>(
            CxboxMyExample3086Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3086Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3086Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3086Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3086Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3086Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3086Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3086Controller> {

        public BcSupplier() {
            super(CxboxMyExample3086Controller.Holder);
        }

    }

}
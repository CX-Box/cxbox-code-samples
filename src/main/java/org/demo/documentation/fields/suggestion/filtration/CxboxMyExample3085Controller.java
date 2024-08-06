package org.demo.documentation.fields.suggestion.filtration;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.filtration.forfield.MyExample3096Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3085Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3085(MyExample3085SuggestionService.class),
    myexample3096(MyExample3096Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3085Controller> Holder = new Holder<>(
            CxboxMyExample3085Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3085Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3085Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3085Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3085Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3085Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3085Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3085Controller> {

        public BcSupplier() {
            super(CxboxMyExample3085Controller.Holder);
        }

    }

}
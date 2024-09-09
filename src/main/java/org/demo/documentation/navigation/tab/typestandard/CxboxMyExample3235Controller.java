package org.demo.documentation.navigation.tab.typestandard;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3235Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3235(MyExample3235Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3235Controller> Holder = new Holder<>(
            CxboxMyExample3235Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3235Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3235Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3235Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3235Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3235Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3235Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3235Controller> {

        public BcSupplier() {
            super(CxboxMyExample3235Controller.Holder);
        }

    }

}
package org.demo.documentation.navigation.tab.other.example5;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.navigation.tab.other.example5.parent.MyExample3161Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3160Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample3161(MyExample3161Service.class),
    myexample3160(myexample3161,MyExample3160Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3160Controller> Holder = new Holder<>(
            CxboxMyExample3160Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3160Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3160Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3160Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3160Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3160Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3160Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3160Controller> {

        public BcSupplier() {
            super(CxboxMyExample3160Controller.Holder);
        }

    }

}
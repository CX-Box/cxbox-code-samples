package org.demo.documentation.other.forceactive2;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4901Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample4901(MyExample4901Service.class),

    myexamplefa4901(MyExample4901Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample4901Controller> Holder = new Holder<>(
            CxboxMyExample4901Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4901Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4901Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample4901Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample4901Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample4901Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample4901Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4901Controller> {

        public BcSupplier() {
            super(CxboxMyExample4901Controller.Holder);
        }

    }

}
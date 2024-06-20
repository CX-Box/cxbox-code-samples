package org.demo.documentation.widgets.statsblock.showcondition.data;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4229Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample4229(MyExample4229Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample4229Controller> Holder = new Holder<>(
            CxboxMyExample4229Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4229Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4229Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4229Controller> {

        public BcSupplier() {
            super(CxboxMyExample4229Controller.Holder);
        }

    }

}
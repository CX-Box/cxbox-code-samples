package org.demo.documentation.widgets.statsblock.icon.data;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4222Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample4222(MyExample4222Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample4222Controller> Holder = new Holder<>(
            CxboxMyExample4222Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4222Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4222Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4222Controller> {

        public BcSupplier() {
            super(CxboxMyExample4222Controller.Holder);
        }

    }

}
package org.demo.documentation.widgets.statsblock.base.customfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4200Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc4200(MyExample4200Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample4200Controller> Holder = new Holder<>(
            PlatformMyExample4200Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4200Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample4200Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4200Controller> {

        public BcSupplier() {
            super(PlatformMyExample4200Controller.Holder);
        }

    }

}
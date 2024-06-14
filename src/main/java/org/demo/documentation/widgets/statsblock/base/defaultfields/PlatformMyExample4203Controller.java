package org.demo.documentation.widgets.statsblock.base.defaultfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4203Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc4203(MyExample4203Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample4203Controller> Holder = new Holder<>(
            PlatformMyExample4203Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4203Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }


    PlatformMyExample4203Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4203Controller> {

        public BcSupplier() {
            super(PlatformMyExample4203Controller.Holder);
        }

    }

}
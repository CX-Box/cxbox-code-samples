package org.demo.documentation.microservice;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3800Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc3800(MyExample3800Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample3800Controller> Holder = new Holder<>(
            PlatformMyExample3800Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3800Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3800Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3800Controller> {

        public BcSupplier() {
            super(PlatformMyExample3800Controller.Holder);
        }

    }

}
package org.demo.documentation.microservice.createmicroservices;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that tesler UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >5 rest endpoints)
 */
@Getter
public enum PlatformMyExample3810Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc3810(MyExample3810Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample3810Controller> Holder = new Holder<>(
            PlatformMyExample3810Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3810Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3810Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3810Controller> {

        public BcSupplier() {
            super(PlatformMyExample3810Controller.Holder);
        }

    }

}
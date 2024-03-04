package org.demo.documentation.time.colorconst;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BcIdentifier;
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
public enum PlatformMyExample3502Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc3502(MyExample3502Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample3502Controller> Holder = new Holder<>(
            PlatformMyExample3502Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3502Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3502Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3502Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3502Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3502Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3502Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3502Controller> {

        public BcSupplier() {
            super(PlatformMyExample3502Controller.Holder);
        }

    }

}
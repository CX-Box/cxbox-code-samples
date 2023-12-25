package org.demo.documentation.widgets.info.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyExample3107Service;
import org.demo.documentation.widgets.info.showcondition.byparententity.parent.MyExample3105Service;
import org.springframework.stereotype.Component;

/**
 * This is actually an analog of a usual @RestController.
 * When you add enum, you just add rest endpoints, that tesler UI can call.
 * We could actually make a usual @RestController and make it Generic,
 * but current enum approach shows, that it is less error-prone in huge enterprise projects
 * (because single line in this enum creates >5 rest endpoints)
 */
@Getter
public enum PlatformMyExample31053107Controller implements EnumBcIdentifier {

    // @formatter:on
    // @formatter:on
    // --8<-- [start:bc]
    myExampleBc3105(MyExample3105Service.class),
    myExampleBc3107(myExampleBc3105, MyExample3107Service.class);
    // --8<-- [end:bc]
    // @formatter:on

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample31053107Controller> Holder = new Holder<>(
            PlatformMyExample31053107Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample31053107Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample31053107Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample31053107Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample31053107Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample31053107Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample31053107Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample31053107Controller> {

        public BcSupplier() {
            super(PlatformMyExample31053107Controller.Holder);
        }

    }

}
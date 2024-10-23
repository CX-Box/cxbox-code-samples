package org.demo.documentation.widgets.info.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyExample3107Service;
import org.demo.documentation.widgets.info.showcondition.byparententity.parent.MyExample3105Service;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample31053107Controller implements EnumBcIdentifier {



    // --8<-- [start:bc]
    myExampleBc3105(MyExample3105Service.class),
    myExampleBc3107(myExampleBc3105, MyExample3107Service.class);
    // --8<-- [end:bc]




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
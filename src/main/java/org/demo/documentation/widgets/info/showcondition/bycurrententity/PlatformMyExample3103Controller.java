package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3103Controller implements EnumBcIdentifier {


    myExampleBc3103(MyExample3103Service.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample3103Controller> Holder = new Holder<>(
            PlatformMyExample3103Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3103Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3103Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3103Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3103Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3103Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3103Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3103Controller> {

        public BcSupplier() {
            super(PlatformMyExample3103Controller.Holder);
        }

    }

}
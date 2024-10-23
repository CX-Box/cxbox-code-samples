package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3101Controller implements EnumBcIdentifier {


    myExampleBc3101(MyExample3101Service.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample3101Controller> Holder = new Holder<>(
            PlatformMyExample3101Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3101Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3101Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3101Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3101Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3101Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3101Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3101Controller> {

        public BcSupplier() {
            super(PlatformMyExample3101Controller.Holder);
        }

    }

}
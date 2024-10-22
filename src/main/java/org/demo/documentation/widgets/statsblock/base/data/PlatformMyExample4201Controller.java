package org.demo.documentation.widgets.statsblock.base.data;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4201Controller implements EnumBcIdentifier {


    myExampleBc4201(MyExample4201Service.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample4201Controller> Holder = new Holder<>(
            PlatformMyExample4201Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4201Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }


    PlatformMyExample4201Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4201Controller> {

        public BcSupplier() {
            super(PlatformMyExample4201Controller.Holder);
        }

    }

}
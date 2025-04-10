package org.demo.documentation.widgets.statsblock.color.data;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4204Controller implements EnumBcIdentifier {

    
    myExampleBc4204(MyExample4204Service.class);

    

    public static final EnumBcIdentifier.Holder<PlatformMyExample4204Controller> Holder = new Holder<>(
            PlatformMyExample4204Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4204Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }


    PlatformMyExample4204Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4204Controller> {

        public BcSupplier() {
            super(PlatformMyExample4204Controller.Holder);
        }

    }

}
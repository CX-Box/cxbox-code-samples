package org.demo.documentation.widgets.statsblock.drilldown.data;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4208Controller implements EnumBcIdentifier {

    
    myExampleBc4208(MyExample4208Service.class);

    

    public static final EnumBcIdentifier.Holder<PlatformMyExample4208Controller> Holder = new Holder<>(
            PlatformMyExample4208Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4208Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample4208Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4208Controller> {

        public BcSupplier() {
            super(PlatformMyExample4208Controller.Holder);
        }

    }

}
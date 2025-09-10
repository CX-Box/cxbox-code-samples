package org.demo.documentation.widgets.statsblock.drilldown.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample4210Controller implements EnumBcIdentifier {

    
    myExampleBc4210(MyExample4210Service.class);

    

    public static final EnumBcIdentifier.Holder<PlatformMyExample4210Controller> Holder = new Holder<>(
            PlatformMyExample4210Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4210Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample4210Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4210Controller> {

        public BcSupplier() {
            super(PlatformMyExample4210Controller.Holder);
        }

    }

}
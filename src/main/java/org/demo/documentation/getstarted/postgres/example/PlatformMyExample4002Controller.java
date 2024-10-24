package org.demo.documentation.getstarted.postgres.example;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;



@Getter
public enum PlatformMyExample4002Controller implements EnumBcIdentifier {


    myExampleBc4002(MyExample4002Service.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample4002Controller> Holder = new Holder<>(
            PlatformMyExample4002Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample4002Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample4002Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample4002Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample4002Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample4002Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample4002Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample4002Controller> {

        public BcSupplier() {
            super(PlatformMyExample4002Controller.Holder);
        }

    }

}
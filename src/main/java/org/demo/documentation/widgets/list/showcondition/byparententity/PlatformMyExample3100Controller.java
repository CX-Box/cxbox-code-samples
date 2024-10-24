package org.demo.documentation.widgets.list.showcondition.byparententity;


import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyExample3106Service;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyExample3100Service;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3100Controller implements EnumBcIdentifier {



    myexample3100(MyExample3100Service.class),
    myexample3106(myexample3100,MyExample3106Service.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample3100Controller> Holder = new Holder<>(
            PlatformMyExample3100Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3100Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3100Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3100Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3100Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3100Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3100Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3100Controller> {

        public BcSupplier() {
            super(PlatformMyExample3100Controller.Holder);
        }

    }

}
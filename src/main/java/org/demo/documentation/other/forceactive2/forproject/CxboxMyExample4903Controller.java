package org.demo.documentation.other.forceactive2.forproject;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4903Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample4903(MyExample4903Service.class), myEntity4903FileNamePickPick(myexample4903, MyEntity4903FileNamePickPickService.class),
        myEntity4903InstancePick(myexample4903, MyEntity4903InstancePickService.class), myEntity4903OCPPickPick(myexample4903, MyEntity4903OCPPickPickService.class), myEntity4903PickPick(myexample4903, MyEntity4903PickPickService.class);

    // @formatter:on

    public static final Holder<CxboxMyExample4903Controller> Holder = new Holder<>(
            CxboxMyExample4903Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4903Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4903Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample4903Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample4903Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample4903Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample4903Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4903Controller> {

        public BcSupplier() {
            super(CxboxMyExample4903Controller.Holder);
        }

    }

}
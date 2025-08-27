package org.demo.documentation.widgets.property.sethidden;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5019Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample5019(MyExample5019Service.class), myEntity5019PickPick(myexample5019, MyEntity5019PickPickService.class), myEntity5019MultiPick(myexample5019, MyEntity5019MultiPickService.class);

    // @formatter:on

    public static final Holder<CxboxMyExample5019Controller> Holder = new Holder<>(
            CxboxMyExample5019Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample5019Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample5019Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample5019Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample5019Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample5019Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample5019Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5019Controller> {

        public BcSupplier() {
            super(CxboxMyExample5019Controller.Holder);
        }

    }

}
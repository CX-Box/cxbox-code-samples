package org.demo.documentation.widgets.form.actions.create.withview;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.form.actions.edit.basic.MyExample3301Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3302Controller implements EnumBcIdentifier {



    myexample3302(MyExample3302Service.class),
    myexample3301(MyExample3301Service.class);


    public static final EnumBcIdentifier.Holder<CxboxMyExample3302Controller> Holder = new Holder<>(
            CxboxMyExample3302Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3302Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3302Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3302Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3302Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3302Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3302Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3302Controller> {

        public BcSupplier() {
            super(CxboxMyExample3302Controller.Holder);
        }

    }

}
package org.demo.documentation.widgets.form.actions.create.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.form.actions.edit.basic.MyExample3301Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3300Controller implements EnumBcIdentifier {



    myexample3300(MyExample3300Service.class),
    myexample3301(MyExample3301Service.class);




    public static final EnumBcIdentifier.Holder<CxboxMyExample3300Controller> Holder = new Holder<>(
            CxboxMyExample3300Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3300Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3300Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3300Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3300Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3300Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3300Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3300Controller> {

        public BcSupplier() {
            super(CxboxMyExample3300Controller.Holder);
        }

    }

}
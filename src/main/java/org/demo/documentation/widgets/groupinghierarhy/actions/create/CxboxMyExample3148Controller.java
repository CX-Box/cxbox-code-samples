package org.demo.documentation.widgets.groupinghierarhy.actions.create;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.basic.MyExample3148Service;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.newview.MyExample3149Service;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget.MyExample3159Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3148Controller implements EnumBcIdentifier {

    
    myexample3159(MyExample3159Service.class),
    myexample3148(MyExample3148Service.class),
    myexample3149(MyExample3149Service .class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3148Controller> Holder = new Holder<>(
            CxboxMyExample3148Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3148Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3148Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3148Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3148Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3148Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3148Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3148Controller> {

        public BcSupplier() {
            super(CxboxMyExample3148Controller.Holder);
        }

    }

}
package org.demo.documentation.widgets.groupinghierarhy.actions.edit;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.basic.MyExample3166Service;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview.MyExample3167Service;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.MyExample3168Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3166Controller implements EnumBcIdentifier {

    
    myexample3167(MyExample3167Service.class),
    myexample3168(MyExample3168Service.class),
    myexample3166(MyExample3166Service.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3166Controller> Holder = new Holder<>(
            CxboxMyExample3166Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3166Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3166Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3166Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3166Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3166Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3166Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3166Controller> {

        public BcSupplier() {
            super(CxboxMyExample3166Controller.Holder);
        }

    }

}
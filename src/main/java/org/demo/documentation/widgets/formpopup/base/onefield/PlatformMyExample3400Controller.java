package org.demo.documentation.widgets.formpopup.base.onefield;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.MyEntity3400InlinePicklistPickService;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.fa.MyEntity3400InlinePicklistFAPickService;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3400Controller implements EnumBcIdentifier {


    myExampleBc3400(MyExample3400Service.class),
        myEntity3400InlinePicklistFAPick(myExampleBc3400, MyEntity3400InlinePicklistFAPickService.class),
        myEntity3400InlinePicklistPick(myExampleBc3400, MyEntity3400InlinePicklistPickService.class);



    public static final EnumBcIdentifier.Holder<PlatformMyExample3400Controller> Holder = new Holder<>(
            PlatformMyExample3400Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3400Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3400Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3400Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3400Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3400Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3400Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3400Controller> {

        public BcSupplier() {
            super(PlatformMyExample3400Controller.Holder);
        }

    }

}
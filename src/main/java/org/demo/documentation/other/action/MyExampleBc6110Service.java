package org.demo.documentation.other.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.action.CxboxActionIconSpecifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyExampleBc6110Service extends VersionAwareResponseService<MyExample6110DTO, MyExample6110Entity> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6110Meta> meta = MyExample6110Meta.class;

	@Override
	protected CreateResult<MyExample6110DTO> doCreateEntity(MyExample6110Entity entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample6110DTO> doUpdateEntity(MyExample6110Entity entity, MyExample6110DTO data, BusinessComponent bc) {
		return null;
	}

	@Override
	public Actions<MyExample6110DTO> getActions() {
		return Actions.<MyExample6110DTO>builder()
				.create(cr->cr)
				.addGroup(
						"only_text",
						"only text",
						0,
						Actions.<MyExample6110DTO>builder()
								.action(act -> act
										.action("text", "text")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("edit", "edit")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("delet", "delete")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.addGroup("inner_text_1", "inner text", 0, Actions.<MyExample6110DTO>builder()
										.action(act -> act
												.action("inner_text_1", "text")
												.withoutAutoSaveBefore()
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_edit_1", "edit")
												.withoutAutoSaveBefore()
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_send_1", "send")
												.withoutAutoSaveBefore()
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.addGroup("inner_text_2", "inner text in inner text", 0, Actions.<MyExample6110DTO>builder()
												.action(act -> act
														.action("inner_text_2", "text")
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_edit_2", "edit")
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_delete_2", "delete")
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_perform_2", "perform")
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.build())
										.build()
								)
								.build()
				)

				.addGroup(
						"only_icon",
						"",
						0,
						Actions.<MyExample6110DTO>builder()
								.action(act -> act
										.action("text", "")
										.withoutAutoSaveBefore()
										.withIcon(MyExample6110ActionIconSpecifier.TEXT, true)
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("edit", "")
										.withIcon(MyExample6110ActionIconSpecifier.EDIT, true)
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("delete", "")
										.withoutAutoSaveBefore()
										.withIcon(MyExample6110ActionIconSpecifier.DELETE, true)
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.addGroup("only_icon_1", "1", 0, Actions.<MyExample6110DTO>builder()
										.action(act -> act
												.action("inner_text_1", "")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.TEXT, true)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_edit_1", "")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.EDIT, true)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_send_1", "")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.MAIL, true)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.addGroup("only_icon_2", "", 0, Actions.<MyExample6110DTO>builder()
												.action(act -> act
														.action("inner_text_2", "")
														.withIcon(MyExample6110ActionIconSpecifier.TEXT, true)
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_edit_2", "")
														.withIcon(MyExample6110ActionIconSpecifier.EDIT, true)
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_delete_2", "")
														.withoutAutoSaveBefore()
														.withIcon(MyExample6110ActionIconSpecifier.DELETE, true)
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_perform_2", "")
														.withoutAutoSaveBefore()
														.withIcon(MyExample6110ActionIconSpecifier.PLAY_CIRCLE, true)
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.build())
										.withIcon(MyExample6110ActionIconSpecifier.APP_STORE, true)
										.build()
								)
								.withIcon(MyExample6110ActionIconSpecifier.BRANCH, true)
								.build()
				)
				.withIcon(CxboxActionIconSpecifier.BARS, true)
				.addGroup(
						"mixed",
						"Actions",
						0,
						Actions.<MyExample6110DTO>builder()
								.action(act -> act
										.action("text", "text")
										.withoutAutoSaveBefore()
										.withIcon(MyExample6110ActionIconSpecifier.TEXT, false)
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("edit", "edit")
										.withIcon(MyExample6110ActionIconSpecifier.EDIT, false)
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.action(act -> act
										.action("delete", "delete")
										.withoutAutoSaveBefore()
										.withIcon(MyExample6110ActionIconSpecifier.DELETE, false)
										.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
								.addGroup("mixed_1", "1", 0, Actions.<MyExample6110DTO>builder()
										.action(act -> act
												.action("inner_text_1", "inner_text")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.TEXT, false)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_edit_1", "inner_edit")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.EDIT, false)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.action(act -> act
												.action("inner_send_1", "inner_send")
												.withoutAutoSaveBefore()
												.withIcon(MyExample6110ActionIconSpecifier.MAIL, false)
												.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
										.addGroup("mixed_2", "", 0, Actions.<MyExample6110DTO>builder()
												.action(act -> act
														.action("inner_text_2", "inner_text")
														.withIcon(MyExample6110ActionIconSpecifier.TEXT, false)
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_edit_2", "inner_edit")
														.withIcon(MyExample6110ActionIconSpecifier.EDIT, false)
														.withoutAutoSaveBefore()
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_delete_2", "inner_delete")
														.withoutAutoSaveBefore()
														.withIcon(MyExample6110ActionIconSpecifier.DELETE, false)
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.action(act -> act
														.action("inner_perform_2", "inner_perform")
														.withoutAutoSaveBefore()
														.withIcon(MyExample6110ActionIconSpecifier.PLAY_CIRCLE, false)
														.invoker((bc, data) -> new ActionResultDTO<MyExample6110DTO>().setAction(PostAction.refreshBc(PlatformMyExample6110Controller.myExampleBc6110))))
												.build())
										.withIcon(MyExample6110ActionIconSpecifier.APP_STORE, false)
										.build()
								)
								.withIcon(MyExample6110ActionIconSpecifier.BRANCH, false)
								.build()
				)
				.withIcon(CxboxActionIconSpecifier.BARS, false)
				.build();
	}


}

package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.list.showcondition.bycurrententity.enums.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3101Meta extends FieldMetaBuilder<MyExample3101DTO> {
    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3101DTO_.comment);
        fields.setEnabled(MyExample3101DTO_.remainAmountAfterNotFullQuiting);
        fields.setEnabled(MyExample3101DTO_.document);
        fields.setEnabled(MyExample3101DTO_.regressNumber);
        fields.setEnabled(MyExample3101DTO_.femidaLegalCaseNumber);
        fields.setEnabled(MyExample3101DTO_.creditorDebtAmount);
        fields.setEnabled(MyExample3101DTO_.debtorDebtAmount);
        fields.setEnabled(MyExample3101DTO_.bookkeepingEntryDate);
        fields.setEnabled(MyExample3101DTO_.bookkeepingEntryParentNumber);
        fields.setEnabled(MyExample3101DTO_.expiredBalanceAmount);
        fields.setEnabled(MyExample3101DTO_.balanceSummaryNotConfirmerDebtors);
        fields.setEnumValues(MyExample3101DTO_.balanceSummaryConfirmedDebtors, BalanceSummaryConfirmedDebtorsEnum.values());
        fields.setEnabled(MyExample3101DTO_.balanceSummaryConfirmedDebtors);
        fields.setEnabled(MyExample3101DTO_.balanceSummary);
        fields.setEnabled(MyExample3101DTO_.accountNumber);
        fields.setEnabled(MyExample3101DTO_.bookkeepingAccountName);
        fields.setEnabled(MyExample3101DTO_.businessName);
        fields.setEnabled(MyExample3101DTO_.executiveListPerspective);
        fields.setEnabled(MyExample3101DTO_.debtorInn);
        fields.setEnabled(MyExample3101DTO_.executiveProcedureFinishDate);
        fields.setEnabled(MyExample3101DTO_.executiveProcedureStartDate);
        fields.setEnabled(MyExample3101DTO_.ospName);
        fields.setEnabled(MyExample3101DTO_.fsspName);
        fields.setEnumValues(MyExample3101DTO_.executiveListLocation, ExecutiveListLocationEnum.values());
        fields.setEnabled(MyExample3101DTO_.executiveListLocation);
        fields.setEnabled(MyExample3101DTO_.sspType);
        fields.setEnabled(MyExample3101DTO_.sspNumber);
        fields.setEnabled(MyExample3101DTO_.lastPaymentDate);
        fields.setEnabled(MyExample3101DTO_.executiveListOutgoingDebtAmount);
        fields.setEnabled(MyExample3101DTO_.executiveListOutgoingAmount);
        fields.setEnabled(MyExample3101DTO_.caseNumber);
        fields.setEnabled(MyExample3101DTO_.executiveListNumber);
        fields.setEnabled(MyExample3101DTO_.electronicFlg);
        fields.setEnumValues(MyExample3101DTO_.articleReason, ArticleReasonEnum.values());
        fields.setEnabled(MyExample3101DTO_.articleReason);
        fields.setEnumValues(MyExample3101DTO_.inventoryReason, InventoryReasonEnum.values());
        fields.setEnabled(MyExample3101DTO_.inventoryReason);
        fields.setEnabled(MyExample3101DTO_.managerDecisionDate);
        fields.setEnabled(MyExample3101DTO_.managerNameDecision);
        fields.setEnumValues(MyExample3101DTO_.managerDecision, ManagerDecisionEnum.values());
        fields.setEnabled(MyExample3101DTO_.managerDecision);
        fields.setEnabled(MyExample3101DTO_.division);
        fields.setEnabled(MyExample3101DTO_.branchOrDivision);
        fields.setEnabled(MyExample3101DTO_.regionCenterOrMainOffice);
        fields.setEnabled(MyExample3101DTO_.requirementCurator);
        fields.setEnabled(MyExample3101DTO_.defendantBirthDate);
        fields.setEnabled(MyExample3101DTO_.defendantName);
        fields.setEnabled(MyExample3101DTO_.bankruptcyAttributeDate);
        fields.setEnabled(MyExample3101DTO_.bankruptcyAttribute);
        fields.setEnabled(MyExample3101DTO_.requirementStep);
        fields.setEnumValues(MyExample3101DTO_.requirementStatus, RequirementStatusEnum.values());
        fields.setEnabled(MyExample3101DTO_.requirementStatus);
        fields.setEnabled(MyExample3101DTO_.requirementClosingDate);
        fields.setEnabled(MyExample3101DTO_.requirementType);
        fields.setEnabled(MyExample3101DTO_.lossNumber);
        fields.setEnumValues(MyExample3101DTO_.legalCaseType, LegalCaseTypeEnum.values());
        fields.setEnabled(MyExample3101DTO_.legalCaseType);
        fields.setEnabled(MyExample3101DTO_.contractNumber);
        fields.setEnabled(MyExample3101DTO_.legalCaseFemidaNumber);
        fields.setEnabled(MyExample3101DTO_.legalCaseAisNumber);
        fields.setEnabled(MyExample3101DTO_.bookkeepingComment);
        fields.setEnumValues(MyExample3101DTO_.payerClassification, PayerClassificationEnum.values());
        fields.setEnabled(MyExample3101DTO_.payerClassification);
        fields.setEnabled(MyExample3101DTO_.clientName);
        fields.setEnabled(MyExample3101DTO_.debtAmount);
        fields.setEnabled(MyExample3101DTO_.receiptAmount);
        fields.setEnabled(MyExample3101DTO_.accrualAmount);
        fields.setEnabled(MyExample3101DTO_.accrualTransactionAisNumber);
        fields.setEnabled(MyExample3101DTO_.bookkeepingAccountNumber);
        fields.setEnabled(MyExample3101DTO_.bookkeepingNumber);
        fields.setEnabled(MyExample3101DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3101DTO_.comment);
        fields.enableFilter(MyExample3101DTO_.remainAmountAfterNotFullQuiting);
        fields.enableFilter(MyExample3101DTO_.document);
        fields.enableFilter(MyExample3101DTO_.regressNumber);
        fields.enableFilter(MyExample3101DTO_.femidaLegalCaseNumber);
        fields.enableFilter(MyExample3101DTO_.creditorDebtAmount);
        fields.enableFilter(MyExample3101DTO_.debtorDebtAmount);
        fields.enableFilter(MyExample3101DTO_.bookkeepingEntryDate);
        fields.enableFilter(MyExample3101DTO_.bookkeepingEntryParentNumber);
        fields.enableFilter(MyExample3101DTO_.expiredBalanceAmount);
        fields.enableFilter(MyExample3101DTO_.balanceSummaryNotConfirmerDebtors);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.balanceSummaryConfirmedDebtors, BalanceSummaryConfirmedDebtorsEnum.values());
        fields.enableFilter(MyExample3101DTO_.balanceSummaryConfirmedDebtors);
        fields.enableFilter(MyExample3101DTO_.balanceSummary);
        fields.enableFilter(MyExample3101DTO_.accountNumber);
        fields.enableFilter(MyExample3101DTO_.bookkeepingAccountName);
        fields.enableFilter(MyExample3101DTO_.businessName);
        fields.enableFilter(MyExample3101DTO_.executiveListPerspective);
        fields.enableFilter(MyExample3101DTO_.debtorInn);
        fields.enableFilter(MyExample3101DTO_.executiveProcedureFinishDate);
        fields.enableFilter(MyExample3101DTO_.executiveProcedureStartDate);
        fields.enableFilter(MyExample3101DTO_.ospName);
        fields.enableFilter(MyExample3101DTO_.fsspName);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.executiveListLocation, ExecutiveListLocationEnum.values());
        fields.enableFilter(MyExample3101DTO_.executiveListLocation);
        fields.enableFilter(MyExample3101DTO_.sspType);
        fields.enableFilter(MyExample3101DTO_.sspNumber);
        fields.enableFilter(MyExample3101DTO_.lastPaymentDate);
        fields.enableFilter(MyExample3101DTO_.executiveListOutgoingDebtAmount);
        fields.enableFilter(MyExample3101DTO_.executiveListOutgoingAmount);
        fields.enableFilter(MyExample3101DTO_.caseNumber);
        fields.enableFilter(MyExample3101DTO_.executiveListNumber);
        fields.enableFilter(MyExample3101DTO_.electronicFlg);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.articleReason, ArticleReasonEnum.values());
        fields.enableFilter(MyExample3101DTO_.articleReason);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.inventoryReason, InventoryReasonEnum.values());
        fields.enableFilter(MyExample3101DTO_.inventoryReason);
        fields.enableFilter(MyExample3101DTO_.managerDecisionDate);
        fields.enableFilter(MyExample3101DTO_.managerNameDecision);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.managerDecision, ManagerDecisionEnum.values());
        fields.enableFilter(MyExample3101DTO_.managerDecision);
        fields.enableFilter(MyExample3101DTO_.division);
        fields.enableFilter(MyExample3101DTO_.branchOrDivision);
        fields.enableFilter(MyExample3101DTO_.regionCenterOrMainOffice);
        fields.enableFilter(MyExample3101DTO_.requirementCurator);
        fields.enableFilter(MyExample3101DTO_.defendantBirthDate);
        fields.enableFilter(MyExample3101DTO_.defendantName);
        fields.enableFilter(MyExample3101DTO_.bankruptcyAttributeDate);
        fields.enableFilter(MyExample3101DTO_.bankruptcyAttribute);
        fields.enableFilter(MyExample3101DTO_.requirementStep);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.requirementStatus, RequirementStatusEnum.values());
        fields.enableFilter(MyExample3101DTO_.requirementStatus);
        fields.enableFilter(MyExample3101DTO_.requirementClosingDate);
        fields.enableFilter(MyExample3101DTO_.requirementType);
        fields.enableFilter(MyExample3101DTO_.lossNumber);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.legalCaseType, LegalCaseTypeEnum.values());
        fields.enableFilter(MyExample3101DTO_.legalCaseType);
        fields.enableFilter(MyExample3101DTO_.contractNumber);
        fields.enableFilter(MyExample3101DTO_.legalCaseFemidaNumber);
        fields.enableFilter(MyExample3101DTO_.legalCaseAisNumber);
        fields.enableFilter(MyExample3101DTO_.bookkeepingComment);
        fields.setEnumFilterValues(fields, MyExample3101DTO_.payerClassification, PayerClassificationEnum.values());
        fields.enableFilter(MyExample3101DTO_.payerClassification);
        fields.enableFilter(MyExample3101DTO_.clientName);
        fields.enableFilter(MyExample3101DTO_.debtAmount);
        fields.enableFilter(MyExample3101DTO_.receiptAmount);
        fields.enableFilter(MyExample3101DTO_.accrualAmount);
        fields.enableFilter(MyExample3101DTO_.accrualTransactionAisNumber);
        fields.enableFilter(MyExample3101DTO_.bookkeepingAccountNumber);
        fields.enableFilter(MyExample3101DTO_.bookkeepingNumber);
        fields.enableFilter(MyExample3101DTO_.customField);
        fields.enableSort(MyExample3101DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3101DTO_.customField);
        }
    }
    // --8<-- [end:buildIndependentMeta]
}
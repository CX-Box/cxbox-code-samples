package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3101Service extends VersionAwareResponseService<MyExample3101DTO, MyEntity3101> {

    private final MyEntity3101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3101Meta> meta = MyExample3101Meta.class;

    @Override
    protected CreateResult<MyExample3101DTO> doCreateEntity(MyEntity3101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3101DTO> doUpdateEntity(MyEntity3101 entity, MyExample3101DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3101DTO_.comment, entity::setComment);
        setIfChanged(data, MyExample3101DTO_.remainAmountAfterNotFullQuiting, entity::setRemainAmountAfterNotFullQuiting);
        setIfChanged(data, MyExample3101DTO_.document, entity::setDocument);
        setIfChanged(data, MyExample3101DTO_.regressNumber, entity::setRegressNumber);
        setIfChanged(data, MyExample3101DTO_.femidaLegalCaseNumber, entity::setFemidaLegalCaseNumber);
        setIfChanged(data, MyExample3101DTO_.creditorDebtAmount, entity::setCreditorDebtAmount);
        setIfChanged(data, MyExample3101DTO_.debtorDebtAmount, entity::setDebtorDebtAmount);
        setIfChanged(data, MyExample3101DTO_.bookkeepingEntryDate, entity::setBookkeepingEntryDate);
        setIfChanged(data, MyExample3101DTO_.bookkeepingEntryParentNumber, entity::setBookkeepingEntryParentNumber);
        setIfChanged(data, MyExample3101DTO_.expiredBalanceAmount, entity::setExpiredBalanceAmount);
        setIfChanged(data, MyExample3101DTO_.balanceSummaryNotConfirmerDebtors, entity::setBalanceSummaryNotConfirmerDebtors);
        setIfChanged(data, MyExample3101DTO_.balanceSummaryConfirmedDebtors, entity::setBalanceSummaryConfirmedDebtors);
        setIfChanged(data, MyExample3101DTO_.balanceSummary, entity::setBalanceSummary);
        setIfChanged(data, MyExample3101DTO_.accountNumber, entity::setAccountNumber);
        setIfChanged(data, MyExample3101DTO_.bookkeepingAccountName, entity::setBookkeepingAccountName);
        setIfChanged(data, MyExample3101DTO_.businessName, entity::setBusinessName);
        setIfChanged(data, MyExample3101DTO_.executiveListPerspective, entity::setExecutiveListPerspective);
        setIfChanged(data, MyExample3101DTO_.debtorInn, entity::setDebtorInn);
        setIfChanged(data, MyExample3101DTO_.executiveProcedureFinishDate, entity::setExecutiveProcedureFinishDate);
        setIfChanged(data, MyExample3101DTO_.executiveProcedureStartDate, entity::setExecutiveProcedureStartDate);
        setIfChanged(data, MyExample3101DTO_.ospName, entity::setOspName);
        setIfChanged(data, MyExample3101DTO_.fsspName, entity::setFsspName);
        setIfChanged(data, MyExample3101DTO_.executiveListLocation, entity::setExecutiveListLocation);
        setIfChanged(data, MyExample3101DTO_.sspType, entity::setSspType);
        setIfChanged(data, MyExample3101DTO_.sspNumber, entity::setSspNumber);
        setIfChanged(data, MyExample3101DTO_.lastPaymentDate, entity::setLastPaymentDate);
        setIfChanged(data, MyExample3101DTO_.executiveListOutgoingDebtAmount, entity::setExecutiveListOutgoingDebtAmount);
        setIfChanged(data, MyExample3101DTO_.executiveListOutgoingAmount, entity::setExecutiveListOutgoingAmount);
        setIfChanged(data, MyExample3101DTO_.caseNumber, entity::setCaseNumber);
        setIfChanged(data, MyExample3101DTO_.executiveListNumber, entity::setExecutiveListNumber);
        setIfChanged(data, MyExample3101DTO_.electronicFlg, entity::setElectronicFlg);
        setIfChanged(data, MyExample3101DTO_.articleReason, entity::setArticleReason);
        setIfChanged(data, MyExample3101DTO_.inventoryReason, entity::setInventoryReason);
        setIfChanged(data, MyExample3101DTO_.managerDecisionDate, entity::setManagerDecisionDate);
        setIfChanged(data, MyExample3101DTO_.managerNameDecision, entity::setManagerNameDecision);
        setIfChanged(data, MyExample3101DTO_.managerDecision, entity::setManagerDecision);
        setIfChanged(data, MyExample3101DTO_.division, entity::setDivision);
        setIfChanged(data, MyExample3101DTO_.branchOrDivision, entity::setBranchOrDivision);
        setIfChanged(data, MyExample3101DTO_.regionCenterOrMainOffice, entity::setRegionCenterOrMainOffice);
        setIfChanged(data, MyExample3101DTO_.requirementCurator, entity::setRequirementCurator);
        setIfChanged(data, MyExample3101DTO_.defendantBirthDate, entity::setDefendantBirthDate);
        setIfChanged(data, MyExample3101DTO_.defendantName, entity::setDefendantName);
        setIfChanged(data, MyExample3101DTO_.bankruptcyAttributeDate, entity::setBankruptcyAttributeDate);
        setIfChanged(data, MyExample3101DTO_.bankruptcyAttribute, entity::setBankruptcyAttribute);
        setIfChanged(data, MyExample3101DTO_.requirementStep, entity::setRequirementStep);
        setIfChanged(data, MyExample3101DTO_.requirementStatus, entity::setRequirementStatus);
        setIfChanged(data, MyExample3101DTO_.requirementClosingDate, entity::setRequirementClosingDate);
        setIfChanged(data, MyExample3101DTO_.requirementType, entity::setRequirementType);
        setIfChanged(data, MyExample3101DTO_.lossNumber, entity::setLossNumber);
        setIfChanged(data, MyExample3101DTO_.legalCaseType, entity::setLegalCaseType);
        setIfChanged(data, MyExample3101DTO_.contractNumber, entity::setContractNumber);
        setIfChanged(data, MyExample3101DTO_.legalCaseFemidaNumber, entity::setLegalCaseFemidaNumber);
        setIfChanged(data, MyExample3101DTO_.legalCaseAisNumber, entity::setLegalCaseAisNumber);
        setIfChanged(data, MyExample3101DTO_.bookkeepingComment, entity::setBookkeepingComment);
        setIfChanged(data, MyExample3101DTO_.payerClassification, entity::setPayerClassification);
        setIfChanged(data, MyExample3101DTO_.clientName, entity::setClientName);
        setIfChanged(data, MyExample3101DTO_.debtAmount, entity::setDebtAmount);
        setIfChanged(data, MyExample3101DTO_.receiptAmount, entity::setReceiptAmount);
        setIfChanged(data, MyExample3101DTO_.accrualAmount, entity::setAccrualAmount);
        setIfChanged(data, MyExample3101DTO_.accrualTransactionAisNumber, entity::setAccrualTransactionAisNumber);
        setIfChanged(data, MyExample3101DTO_.bookkeepingAccountNumber, entity::setBookkeepingAccountNumber);
        setIfChanged(data, MyExample3101DTO_.bookkeepingNumber, entity::setBookkeepingNumber);
        if (data.isFieldChanged(MyExample3101DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3101DTO> getActions() {
        return Actions.<MyExample3101DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}
package com.zju.medical.common.pojo.xdo;

/**
 * @author xiaoguo
 */
public class ClinicalInfoDOWithBLOBs extends ClinicalInfoDO {
    private String chiefComplaint;

    private String presentIllnessHistory;

    private String treatmentHistory;

    private String pastHistory;

    private String personalHistory;

    private String familyHistory;

    private String treatmentProposal;

    private Integer symptomTime;

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint == null ? null : chiefComplaint.trim();
    }

    public String getPresentIllnessHistory() {
        return presentIllnessHistory;
    }

    public void setPresentIllnessHistory(String presentIllnessHistory) {
        this.presentIllnessHistory = presentIllnessHistory == null ? null : presentIllnessHistory.trim();
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory == null ? null : treatmentHistory.trim();
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory == null ? null : pastHistory.trim();
    }

    public String getPersonalHistory() {
        return personalHistory;
    }

    public void setPersonalHistory(String personalHistory) {
        this.personalHistory = personalHistory == null ? null : personalHistory.trim();
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory == null ? null : familyHistory.trim();
    }

    public String getTreatmentProposal() {
        return treatmentProposal;
    }

    public void setTreatmentProposal(String treatmentProposal) {
        this.treatmentProposal = treatmentProposal == null ? null : treatmentProposal.trim();
    }

    @Override
    public Integer getSymptomTime() {
        return symptomTime;
    }

    @Override
    public void setSymptomTime(Integer symptomTime) {
        this.symptomTime = symptomTime;
    }
}
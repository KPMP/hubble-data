package org.kpmp.spatialViewerDataset;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.*;
import org.springframework.lang.Nullable;
import org.apache.commons.text.WordUtils;
import org.kpmp.file.File;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sv_link_v")
public class SpatialViewerExternalLinkDataset implements SpatialViewerDataset {

    @Id
    @Column(name = "external_link")
    private String externalLink;
    private String configType;
    private String imageType;
    private String dataType;
    private String spectrackSampleId;	
    private String redcapId;
    private int participantId;
    private String age;
    private String protocol;
    private String sampleType;
    private String sex;
    private String tissueSource;
    private String enrollmentCategory;
    private Double releaseVersion;
    @Column(name = "primary_adjudicated_cat")
    private String primaryAdjudicatedCategory;
    private String kdigoStage;
    private String baselineEgfr;
    private String proteinuria;
    private String a1c;
    private String albuminuria;
    private String diabetesHistory;
    private String diabetesDuration;
    private String hypertensionDuration;
    private String hypertensionHistory;
    private String onRaasBlockade;
    private String race;


    @Transient
    private String releaseVersionDisplay;

    @Transient
    private int participantIdSort;

    @Transient
    private String imageTypeSort;

    @JsonProperty("externallink")
    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    @JsonProperty("configtype")
    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    @JsonProperty("imagetype")
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @JsonProperty("datatype")
    public String getDataType() {
            return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Nullable
    @JsonProperty("spectracksampleid")
    public String getSpectrackSampleId() {
        return spectrackSampleId;
    }

    public void setSpectrackSampleId(String spectrackSampleId) {
        this.spectrackSampleId = spectrackSampleId;
    }

    @Nullable
    @JsonProperty("redcapid")
    public String getRedcapId() {
        return redcapId;
    }

    public void setRedcapId(String redcapId) {
        this.redcapId = redcapId;
    }

    @JsonProperty("participantid")
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Nullable
    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Nullable
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Nullable
    @JsonProperty("sampletype")
    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    @Nullable
    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Nullable
    @JsonProperty("tissuesource")
    public String getTissueSource() {
        return tissueSource;
    }

    public void setTissueSource(String tissueSource) {
        this.tissueSource = tissueSource;
    }

    @Nullable
    @JsonProperty("enrollmentcategory")
    public String getEnrollmentCategory(){
        return enrollmentCategory;
    }

    public void setEnrollmentCategory(String enrollmentCategory){
        this.enrollmentCategory = enrollmentCategory;
    }

    @JsonIgnore
    public Double getReleaseVersion(){
        return releaseVersion;
    }

    public void setReleaseVersion(Double releaseVersion){
        this.releaseVersion = releaseVersion;
    }

    @JsonProperty("releaseversion")
    public String getReleaseVersionDisplay() {
        return releaseVersionDisplay;
    }

    public void setReleaseVersionDisplay(String releaseVersionDisplay) {
        this.releaseVersionDisplay = releaseVersionDisplay;
    }

    @JsonProperty("primaryadjudicatedcategory")
    public String getPrimaryAdjudicatedCategory() {
        return this.primaryAdjudicatedCategory;
    }

    public void setPrimaryAdjudicatedCategory(String primaryAdjudicatedCategory) {
        this.primaryAdjudicatedCategory = primaryAdjudicatedCategory;
    }

    @JsonProperty("kdigostage")
    public String getKdigoStage() {
        if(this.kdigoStage.isEmpty()){
            return null;
        }else{
            return this.kdigoStage;
        }
    }

    public void setKdigoStage(String kdigoStage) {
        this.kdigoStage = kdigoStage;
    }

    @JsonProperty("baselineegfr")
    public String getBaselineEgfr() {
        if(this.baselineEgfr.isEmpty()){
            return null;
        }else{
            return this.baselineEgfr;
        }
    }

    public void setBaselineEgfr(String baselineEgfr) {
        this.baselineEgfr = baselineEgfr;
    }

    @JsonProperty("proteinuria")
    public String getProteinuria() {
        if(this.proteinuria.isEmpty()){
            return null;
        }else {
            return this.proteinuria;
        }
    }

    public void setProteinuria(String proteinuria) {
        this.proteinuria = proteinuria;
    }

    @JsonProperty("a1c")
    public String getA1c() {
        if(this.a1c.isEmpty()){
            return null;
        }else {
            return this.a1c;
        }
    }

    public void setA1c(String a1c) {
        this.a1c = a1c;
    }

    @JsonProperty("albuminuria")
    public String getAlbuminuria() {
        if(this.albuminuria.isEmpty()){
            return null;
        }else{
            return albuminuria;
        }
    }

    public void setAlbuminuria(String albuminuria) {
        this.albuminuria = albuminuria;
    }

    @JsonProperty("diabeteshistory")
    public String getDiabetesHistory() {
        if(this.diabetesHistory.isEmpty()){
            return null;
        }else{
            return fixCapitalization(this.diabetesHistory);
        }
    }

    public void setDiabetesHistory(String diabetesHistory) {
        this.diabetesHistory = diabetesHistory;
    }

    @JsonProperty("diabetesduration")
    public String getDiabetesDuration() {
        if(this.diabetesDuration.isEmpty()){
            return null;
        }else{
            return this.diabetesDuration;
        }
    }

    public void setDiabetesDuration(String diabetesDuration) {
        this.diabetesDuration = diabetesDuration;
    }

    @JsonProperty("hypertensionduration")
    public String getHypertensionDuration() {
        if(this.hypertensionDuration.isEmpty()){
            return null;
        }else{
            return this.hypertensionDuration;
        }
    }

    public void setHypertensionDuration(String hypertensionDuration) {
        this.hypertensionDuration = hypertensionDuration;
    }

    @JsonProperty("hypertensionhistory")
    public String getHypertensionHistory() {
        if(this.hypertensionHistory.isEmpty()){
            return null;
        }else{
            return fixCapitalization(this.hypertensionHistory);
        }
    }

    public void setHypertensionHistory(String hypertensionHistory) {
        this.hypertensionHistory = hypertensionHistory;
    }

    @JsonProperty("onraasblockade")
    public String getOnRaasBlockade() {
        if(this.onRaasBlockade.isEmpty()){
            return null;
        }else{
            return this.onRaasBlockade;
        }
    }

    @JsonProperty("race")
    public String getRace() {
        if(this.race.isEmpty()){
            return null;
        }else {
            return this.race;
        }
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setOnRaasBlockade(String onRaasBlockade) {
        this.onRaasBlockade = onRaasBlockade;
    }
    public void setParticipantIdSort(int participantIdSort) {
        this.participantIdSort = participantIdSort;
    }
    public void setImageTypeSort(String imageTypeSort) {
        this.imageTypeSort = imageTypeSort;
    }

    @JsonProperty("dlfileid")
    public String getDlFileId() {
        return null;
    }
    @Nullable
    @JsonProperty("relatedfiles")
    public List<File> getRelatedFiles() {
        return new ArrayList<>();
    }

    @JsonIgnore
    public String  getFileName() {
        return null;
    }
    @JsonIgnore

    public String  getFileNameSort() {
        return null;
    }


    @JsonProperty("image_type_sort")
    public String getImageTypeSort() {
        return imageType.toLowerCase();
    }

    @JsonProperty("participant_id_sort")
    public int getParticipantIdSort() {
        return Integer.parseInt(redcapId.replace("-", "").replace("[", "").replace("]", ""));
    }

    @JsonIgnore
    public int getFileId() {
        return (Integer) null;
    }
    @JsonIgnore

    public Long getFileSize() {
        return null;
    }
    @JsonIgnore

    public String getPackageId() {
        return null;
    }
    @JsonIgnore

    public String getLevel() {
        return null;
    }

     public String fixCapitalization(String input){
        String updatedInput = WordUtils.capitalizeFully(input);
        return updatedInput;
    }
    
}

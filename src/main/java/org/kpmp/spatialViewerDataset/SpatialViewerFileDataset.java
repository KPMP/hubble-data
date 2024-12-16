package org.kpmp.spatialViewerDataset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.text.WordUtils;
import org.kpmp.file.File;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
@Table(name = "sv_file_v")
@JsonPropertyOrder(
        {"externallink","configtype","imagetype","datatype","spectracksampleid","redcapid","participantid","age","protocol","sampletype","sex","tissuesource","enrollmentcategory","primaryadjudicatedcategory","kdigostage","baselineegfr","proteinuria","a1c","albuminuria","diabeteshistory","diabetesduration","hypertensionduration","hypertensionhistory","onraasblockade","race","releaseversion","participant_id_sort","image_type_sort","dlfileid","relatedfiles"}
)
public class SpatialViewerFileDataset implements SpatialViewerDataset {
    private static final int UUID_LENGTH = 37;

    @Id
    @Column(name = "file_id")
    private int fileId;
    private String configType;
    private String imageType = "";
    private String dataType;
    private String dlFileId;
    private String fileName;
    private String packageId;
    private Long fileSize;
    private int participantId;
    private String redcapId = "";
    private String age;
    private String protocol;
    private String sampleType;
    private String sex;
    private String tissueSource;
    private String enrollmentCategory;
    private String spectrackSampleId;
    private String level;
    private Double releaseVersion;
    @Column(name = "primary_adjudicated_cat")
    private String primaryAdjudicatedCategory;
    private String kdigoStage = "";
    private String baselineEgfr = "";
    private String proteinuria = "";
    private String a1c = "";
    private String albuminuria = "";
    private String diabetesHistory = "";
    private String diabetesDuration = "";
    private String hypertensionDuration = "";
    private String hypertensionHistory = "";
    private String onRaasBlockade = "";
    private String race = "";
    
    @Transient
    private String releaseVersionDisplay;

    @Transient
    private String fileNameSort;

    @Transient
    private int participantIdSort;

    @Transient
    private String imageTypeSort;

    @JoinTable(
            name = "sv_related_files",
            joinColumns = @JoinColumn(
                    name = "file_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "related_file_id"
            )
    )
    @ManyToMany(fetch = FetchType.EAGER)
    private List<File> relatedFiles;

    @JsonProperty("fileid")
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @JsonProperty("dlfileid")
    public String getDlFileId() {
        return dlFileId;
    }

    public void setDlFileId(String dlFileId) {
        this.dlFileId = dlFileId;
    }

    @JsonProperty("filename")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("packageid")
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @JsonProperty("filesize")
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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

    @JsonProperty("participantid")
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @JsonProperty("redcapid")
    public String getRedcapId() {
        return redcapId;
    }

    public void setRedcapId(String redcapId) {
        this.redcapId = redcapId;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("sampletype")
    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonProperty("tissuesource")
    public String getTissueSource() {
        return tissueSource;
    }

    public void setTissueSource(String tissueSource) {
        this.tissueSource = tissueSource;
    }

    @JsonProperty("enrollmentcategory")
    public String getEnrollmentCategory() {
        return enrollmentCategory;
    }

    public void setEnrollmentCategory(String enrollmentCategory) {
        this.enrollmentCategory = enrollmentCategory;
    }

    @JsonProperty("spectracksampleid")
    public String getSpectrackSampleId() {
        return spectrackSampleId;
    }
    
    public void setSpectrackSampleId(String spectrackSampleId) {
        this.spectrackSampleId = spectrackSampleId;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("relatedfiles")
    public List<File> getRelatedFiles() {
        return relatedFiles;
    }

    public void setRelatedFiles(List<File> relatedFiles) {
        this.relatedFiles = relatedFiles;
    }

    @JsonProperty("externallink")
    public String getExternalLink() {
        return null;
    }

    @JsonProperty("spatialviewerdataset")
    public Object getSpatialViewerDataset() {
      return null;
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
        return this.kdigoStage.isBlank() ? null : this.kdigoStage + " (ks)";
    }

    public void setKdigoStage(String kdigoStage) {
        this.kdigoStage = kdigoStage;
    }

    @JsonProperty("baselineegfr")
    public String getBaselineEgfr() {
        return this.baselineEgfr.isBlank() ? null : this.baselineEgfr + " (eGFR)";
    }

    public void setBaselineEgfr(String baselineEgfr) {
        this.baselineEgfr = baselineEgfr;
    }

    @JsonProperty("proteinuria")
    public String getProteinuria() {
        return this.proteinuria.isBlank() ? null : this.proteinuria + " (prot)";
    }

    public void setProteinuria(String proteinuria) {
        this.proteinuria = proteinuria;
    }

    @JsonProperty("a1c")
    public String getA1c() {
        return this.a1c.isBlank() ? null : this.a1c + " (a1c)";
    }

    public void setA1c(String a1c) {
        this.a1c = a1c;
    }

    @JsonProperty("albuminuria")
    public String getAlbuminuria() {
        return this.albuminuria.isBlank() ? null : this.albuminuria + " (alb)";
    }

    public void setAlbuminuria(String albuminuria) {
        this.albuminuria = albuminuria;
    }

    @JsonProperty("diabeteshistory")
    public String getDiabetesHistory() {
        return this.diabetesHistory.isBlank() ? null : this.diabetesHistory + " (dh)";
    }

    public void setDiabetesHistory(String diabetesHistory) {
        this.diabetesHistory = diabetesHistory;
    }

    @JsonProperty("diabetesduration")
    public String getDiabetesDuration() {
        return this.diabetesDuration.isBlank() ? null : this.diabetesDuration + " (dd)";
    }

    public void setDiabetesDuration(String diabetesDuration) {
        this.diabetesDuration = diabetesDuration;
    }

    @JsonProperty("hypertensionduration")
    public String getHypertensionDuration() {
        return this.hypertensionDuration.isBlank() ? null : this.hypertensionDuration + " (hd)";
    }

    public void setHypertensionDuration(String hypertensionDuration) {
        this.hypertensionDuration = hypertensionDuration;
    }

    @JsonProperty("hypertensionhistory")
    public String getHypertensionHistory() {
        return this.hypertensionHistory.isBlank() ? null : this.hypertensionHistory + " (hh)";
    }

    public void setHypertensionHistory(String hypertensionHistory) {
        this.hypertensionHistory = hypertensionHistory;
    }

    @JsonProperty("onraasblockade")
    public String getOnRaasBlockade() {
        return this.onRaasBlockade.isBlank() ? null : this.onRaasBlockade + " (rb)";
    }

    public void setOnRaasBlockade(String onRaasBlockade){
        this.onRaasBlockade = onRaasBlockade;
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

    public void setImageTypeSort(String imageTypeSort) {
        this.imageTypeSort = imageTypeSort;
    }

    
    @JsonProperty("file_name_sort")
    public String getFileNameSort() {
        if(this.fileName == null || this.fileName.isEmpty()){
            return null;
        }else{
            this.fileNameSort = fileName.substring(UUID_LENGTH, fileName.length());
            return this.fileNameSort.toLowerCase();
        }
    }

    @JsonProperty("participant_id_sort")
    public int getParticipantIdSort() {
        return Integer.parseInt(redcapId.replace("-", "").replace("[", "").replace("]", ""));
    }

    @JsonProperty("image_type_sort")
    public String getImageTypeSort() {
        return this.imageType.toLowerCase();
    }

    public void setFileNameSort(String fileNameSort) {
        this.fileNameSort = fileNameSort;
    }

    public void setParticipantIdSort(int participantIdSort) {
        this.participantIdSort = participantIdSort;
    }

    public String fixCapitalization(String input){
        String updatedInput = WordUtils.capitalizeFully(input);
        return updatedInput;
    }
}

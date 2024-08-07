package org.kpmp.spatialViewerDataset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SpatialViewerFileDataset implements SpatialViewerDataset {
    private static final int UUID_LENGTH = 37;

    @Id
    @Column(name = "file_id")
    private int fileId;
    private String configType;
    private String imageType;
    private String dataType;
    private String dlFileId;
    private String fileName;
    private String packageId;
    private Long fileSize;
    private int participantId;
    private String redcapId;
    private String age;
    private String protocol;
    private String sampleType;
    private String sex;
    private String tissueSource;
    private String tissueType;
    private String spectrackSampleId;
    private String level;
    private Double releaseVersion;
    
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

    @JsonProperty("tissuetype")
    public String getTissueType() {
        return tissueType;
    }

    public void setTissueType(String tissueType) {
        this.tissueType = tissueType;
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
}

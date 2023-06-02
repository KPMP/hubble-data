package org.kpmp.spatialViewerDataset;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;
import org.kpmp.file.File;
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
    private String tissueType;

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
    @JsonProperty("tissuetype")
    public String getTissueType(){
        return tissueType;
    }

    public void setTissueType(String tissueType){
        this.tissueType = tissueType;
    }

    @JsonProperty("dlfileid")
    public String getDlFileId() {
        return null;
    }

    @JsonProperty("relatedfiles")
    public List<File> getRelatedFiles() {
        return null;
    }

    @JsonProperty("filename")
    public String  getFileName() {
        return null;
    }

    @JsonProperty("fileid")
    public int getFileId() {
        return (Integer) null;
    }

    @JsonProperty("filesize")
    public Long getFileSize() {
        return null;
    }

    @JsonProperty("packageid")
    public String getPackageId() {
        return null;
    }

    @JsonProperty("level")
    public String getLevel() {
        return null;
    }    
}

package org.kpmp.spatialViewerDataset;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sv_file_v")
public class SpatialViewerDataset {

    @Id
    private int fileId;
    private String dlFileId;
    private String fileName;
    private String packageId;
    private Long fileSize;
    private String configType;
    private String imageType;
    private String dataType;
    private String spectrackSampleId;
    private int participantId;
    private String redcapId;
    private String age;
    private String protocol;
    private String sampleType;
    private String sex;
    private String tissueSource;
    private String tissueType;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getDlFileId() {
        return dlFileId;
    }

    public void setDlFileId(String dlFileId) {
        this.dlFileId = dlFileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getRedcapId() {
        return redcapId;
    }

    public void setRedcapId(String redcapId) {
        this.redcapId = redcapId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTissueSource() {
        return tissueSource;
    }

    public void setTissueSource(String tissueSource) {
        this.tissueSource = tissueSource;
    }

    public String getTissueType() {
        return tissueType;
    }

    public void setTissueType(String tissueType) {
        this.tissueType = tissueType;
    }

    public String getSpectrackSampleId() {
        return spectrackSampleId;
    }
    
    public void setSpectrackSampleId(String spectrackSampleId) {
        this.spectrackSampleId = spectrackSampleId;
    }
}

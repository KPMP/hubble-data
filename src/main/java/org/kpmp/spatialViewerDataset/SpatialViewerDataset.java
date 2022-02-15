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
    private String protocol;
    private int metadataTypeId;
    private Double releaseVer;
    private Double releaseSunset;
    private String configType;
    private String imageType;
    private String dataType;

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

    public int getMetadataTypeId() {
        return metadataTypeId;
    }

    public void setMetadataTypeId(int metadataTypeId) {
        this.metadataTypeId = metadataTypeId;
    }

    public Double getReleaseVer() {
        return releaseVer;
    }

    public void setReleaseVer(Double releaseVer) {
        this.releaseVer = releaseVer;
    }

    public Double getReleaseSunset() {
        return releaseSunset;
    }

    public void setReleaseSunset(Double releaseSunset) {
        this.releaseSunset = releaseSunset;
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
}

package org.kpmp.spatialViewerDataset;

import org.kpmp.file.File;
import java.util.List;

public interface SpatialViewerDataset {

  List<File> getRelatedFiles();
  
  String getLevel();
  
  String getSpectrackSampleId();
  
  String getTissueType();
    
  String getTissueSource();
  
  String getSex();
  
  String getSampleType();
  
  String getAge();
  
  String getRedcapId();
  
  int getParticipantId();
  
  String getDataType();
  
  String getImageType();
  
  String getConfigType();
  
  String getProtocol();
  
  Long getFileSize();
  
  String getPackageId();
  
  String getFileName();

  String getFileNameSort();
  
  String getDlFileId();
  
  int getFileId();  
  
  String getExternalLink();

  Double getReleaseVersion();

}


package org.kpmp.spatialViewerDataset;

import org.kpmp.file.File;
import java.util.List;

public interface SpatialViewerDataset {

  List<File> getRelatedFiles();
  
  String getLevel();
  
  String getSpectrackSampleId();
  
  String getEnrollmentCategory();
    
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

  int getParticipantIdSort();

  String getImageTypeSort();
  
  String getDlFileId();
  
  int getFileId();  
  
  String getExternalLink();

  Double getReleaseVersion();

  String getPrimaryAdjudicatedCategory();

  String getKdigoStage();

  String getBaselineEgfr();

  String getProteinuria();

  String getA1c();

  String getAlbuminuria();

  String getDiabetesDuration();

  String getDiabetesHistory();

  String getHypertensionDuration();

  String getHypertensionHistory();

  String getOnRaasBlockade();

  String getRace();

}


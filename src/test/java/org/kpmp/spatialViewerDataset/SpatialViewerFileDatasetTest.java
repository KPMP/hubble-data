package org.kpmp.spatialViewerDataset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kpmp.file.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class SpatialViewerFileDatasetTest {

    private SpatialViewerFileDataset spatialViewerDataset;

    @BeforeEach
    public void setUp() throws Exception {
        spatialViewerDataset = new SpatialViewerFileDataset();
    }

    @AfterEach
    public void tearDown() throws Exception {
        spatialViewerDataset = null;
    }

    @Test
    public void setFileId() {
        spatialViewerDataset.setFileId(12345);
        assertEquals(12345, spatialViewerDataset.getFileId());
    }

    @Test
    public void setDlFileId() {
        spatialViewerDataset.setDlFileId("dl_file_id");
        assertEquals("dl_file_id", spatialViewerDataset.getDlFileId());
    }

    @Test
    public void setFileName() {
        spatialViewerDataset.setFileName("file.jpg");
        assertEquals("file.jpg", spatialViewerDataset.getFileName());
    }

    @Test
    public void setPackageId() {
        spatialViewerDataset.setPackageId("package_id");
        assertEquals("package_id", spatialViewerDataset.getPackageId());
    }

    @Test
    public void setFileSize() {
        spatialViewerDataset.setFileSize((long) 1234123421);
        assertEquals((long) 1234123421, spatialViewerDataset.getFileSize(), 0.01);
    }

    @Test
    public void setProtocol() {
        spatialViewerDataset.setProtocol("blah");
        assertEquals("blah", spatialViewerDataset.getProtocol());
    }

    @Test
    public void setImageType() {
        spatialViewerDataset.setImageType("type");
        assertEquals("type", spatialViewerDataset.getImageType());
    }

    @Test
    public void setDataType() {
        spatialViewerDataset.setDataType("dtype");
        assertEquals("dtype", spatialViewerDataset.getDataType());
    }

    @Test
    public void setParticipantId() {
        spatialViewerDataset.setParticipantId(12);
        assertEquals(12, spatialViewerDataset.getParticipantId());
    }

    @Test
    public void setRedcapId() {
        spatialViewerDataset.setRedcapId("redcapid");
        assertEquals("redcapid", spatialViewerDataset.getRedcapId());
    }

    @Test
    public void setAge() {
        spatialViewerDataset.setAge("age");
        assertEquals("age", spatialViewerDataset.getAge());
    }

    @Test
    public void setSampleType() {
        spatialViewerDataset.setSampleType("sample");
        assertEquals("sample", spatialViewerDataset.getSampleType());
    }

    @Test
    public void setSex() {
        spatialViewerDataset.setSex("sex");
        assertEquals("sex", spatialViewerDataset.getSex());
    }

    @Test
    public void setTissueSource() {
        spatialViewerDataset.setTissueSource("tsource");
        assertEquals("tsource", spatialViewerDataset.getTissueSource());
    }

    @Test
    public void setEnrollmentCategory() {
        spatialViewerDataset.setEnrollmentCategory("ttype");
        assertEquals("ttype", spatialViewerDataset.getEnrollmentCategory());
    }

    @Test
    public void setSpectrackSampleId() {
        spatialViewerDataset.setSpectrackSampleId("spectrack");
        assertEquals("spectrack", spatialViewerDataset.getSpectrackSampleId());
    }

    @Test
    public void setLevel() {
        spatialViewerDataset.setLevel("L0");
        assertEquals("L0", spatialViewerDataset.getLevel());
    }

    @Test
    public void setRelatedFiles() {
        File file = new File();
        List<File> files = Arrays.asList(file);
        spatialViewerDataset.setRelatedFiles(files);
        assertEquals(files, spatialViewerDataset.getRelatedFiles());
    }

    @Test
    public void setReleaseVerison(){
        Double expected = 56.0;
        spatialViewerDataset.setReleaseVersion(56.0);
        assertEquals(expected, spatialViewerDataset.getReleaseVersion());
    }

    @Test 
    public void setReleaseVersionDisplay(){
        spatialViewerDataset.setReleaseVersionDisplay("Recently Released");
        assertEquals("Recently Released", spatialViewerDataset.getReleaseVersionDisplay());
    }

    @Test
    public void setFileNameSort() {
        spatialViewerDataset.setFileName("this_file_name_has_thirty_seven_chrs_filename.docx");
        assertEquals("filename.docx", spatialViewerDataset.getFileNameSort());
    }

    @Test
    public void getImageTypeSort() {
        spatialViewerDataset.setImageType("AbCdEf");
        assertEquals("abcdef", spatialViewerDataset.getImageTypeSort());
    }

    @Test
    public void getParticipantIdSort() {
        spatialViewerDataset.setRedcapId("123-4");
        assertEquals(1234, spatialViewerDataset.getParticipantIdSort());
    }

    @Test
    public void getPrimaryAdjudicatedCategory() {
        spatialViewerDataset.setPrimaryAdjudicatedCategory("TestCategory");
        assertEquals("TestCategory", spatialViewerDataset.getPrimaryAdjudicatedCategory());
    }

    @Test
    public void getKdigoStage() {
        spatialViewerDataset.setKdigoStage("Stage 3");
        assertEquals("Stage 3 (ks)", spatialViewerDataset.getKdigoStage());
    }

    @Test
    public void getKdigoStage_whenBlank() {
        spatialViewerDataset.setKdigoStage("");
        assertEquals(null, spatialViewerDataset.getKdigoStage());
    }

    @Test
    public void getBaselineEgfr() {
        spatialViewerDataset.setBaselineEgfr("60");
        assertEquals("60 (eGFR)", spatialViewerDataset.getBaselineEgfr());
    }

    @Test
    public void getBaselineEgfr_whenBlank() {
        spatialViewerDataset.setBaselineEgfr("");
        assertEquals(null, spatialViewerDataset.getBaselineEgfr());
    }

    @Test
    public void getProteinuria() {
        spatialViewerDataset.setProteinuria("High");
        assertEquals("High (prot)", spatialViewerDataset.getProteinuria());
    }

    @Test
    public void getProteinuria_whenBlank() {
        spatialViewerDataset.setProteinuria("");
        assertEquals(null, spatialViewerDataset.getProteinuria());
    }

    @Test
    public void getA1c() {
        spatialViewerDataset.setA1c("5.6");
        assertEquals("5.6 (a1c)", spatialViewerDataset.getA1c());
    }

    @Test
    public void getA1c_whenBlank() {
        spatialViewerDataset.setA1c("");
        assertEquals(null, spatialViewerDataset.getA1c());
    }

    @Test
    public void getAlbuminuria() {
        spatialViewerDataset.setAlbuminuria("Moderate");
        assertEquals("Moderate (alb)", spatialViewerDataset.getAlbuminuria());
    }

    @Test
    public void getAbluminuria_whenBlank() {
        spatialViewerDataset.setAlbuminuria("");
        assertEquals(null, spatialViewerDataset.getAlbuminuria());
    }

    @Test
    public void getDiabetesHistory() {
        spatialViewerDataset.setDiabetesHistory("Don't Know");
        assertEquals("Don't Know (dh)", spatialViewerDataset.getDiabetesHistory());
    }

    @Test
    public void getDiabetesHistory_whenBlank() {
        spatialViewerDataset.setDiabetesHistory("");
        assertEquals(null, spatialViewerDataset.getDiabetesHistory());
    }

    @Test
    public void getDiabetesDuration() {
        spatialViewerDataset.setDiabetesDuration("10 years");
        assertEquals("10 years (dd)", spatialViewerDataset.getDiabetesDuration());
    }

    @Test
    public void getDiabetesDuration_whenBlank() {
        spatialViewerDataset.setDiabetesDuration("");
        assertEquals(null, spatialViewerDataset.getDiabetesDuration());
    }

    @Test
    public void getHypertensionHistory() {
        spatialViewerDataset.setHypertensionHistory("Don't Know");
        assertEquals("Don't Know (hh)", spatialViewerDataset.getHypertensionHistory());
    }

    @Test
    public void getHypertensionHistory_whenBlank() {
        spatialViewerDataset.setHypertensionHistory("");
        assertEquals(null, spatialViewerDataset.getHypertensionHistory());
    }

    @Test
    public void getHypertensionDuration() {
        spatialViewerDataset.setHypertensionDuration("5 years");
        assertEquals("5 years (hd)", spatialViewerDataset.getHypertensionDuration());
    }

    @Test
    public void getHypertensionDuration_whenBlank() {
        spatialViewerDataset.setHypertensionDuration("");
        assertEquals(null, spatialViewerDataset.getHypertensionDuration());
    }

    @Test
    public void getOnRaasBlockade() {
        spatialViewerDataset.setOnRaasBlockade("Yes");
        assertEquals("Yes (rb)", spatialViewerDataset.getOnRaasBlockade());
    }

    @Test
    public void getOnRaasBlockade_whenBlank() {
        spatialViewerDataset.setOnRaasBlockade("");
        assertEquals(null, spatialViewerDataset.getOnRaasBlockade());
    }

    @Test
    public void getRace() {
        spatialViewerDataset.setRace("Asian");
        assertEquals("Asian", spatialViewerDataset.getRace());
    }

}

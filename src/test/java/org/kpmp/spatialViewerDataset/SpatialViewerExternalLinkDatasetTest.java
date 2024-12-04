package org.kpmp.spatialViewerDataset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpatialViewerExternalLinkDatasetTest {

    private SpatialViewerExternalLinkDataset spatialViewerExternalLink;

    @BeforeEach
    public void setUp() throws Exception {
        spatialViewerExternalLink = new SpatialViewerExternalLinkDataset();
    }

    @AfterEach
    public void tearDown() throws Exception {
        spatialViewerExternalLink = null;
    }

    @Test
    public void setExternalLink() {
        spatialViewerExternalLink.setExternalLink("12345");
        assertEquals("12345", spatialViewerExternalLink.getExternalLink());
    }

    @Test
    public void setConfigType() {
        spatialViewerExternalLink.setConfigType("12345");
        assertEquals("12345", spatialViewerExternalLink.getConfigType());
 
    }

    @Test
    public void setImageType() {
        spatialViewerExternalLink.setImageType("12345");
        assertEquals("12345", spatialViewerExternalLink.getImageType());
    }

    @Test
    public void setDataType() {
        spatialViewerExternalLink.setDataType("12345");
        assertEquals("12345", spatialViewerExternalLink.getDataType());
    }

    @Test
    public void setSpectrackSampleId() {
        spatialViewerExternalLink.setSpectrackSampleId("12345");
        assertEquals("12345", spatialViewerExternalLink.getSpectrackSampleId());
    }

    @Test
    public void setRedcapId() {
        spatialViewerExternalLink.setRedcapId("12345");
        assertEquals("12345", spatialViewerExternalLink.getRedcapId());
    }

    @Test
    public void setParticipantId() {
        spatialViewerExternalLink.setParticipantId(12345);
        assertEquals(12345, spatialViewerExternalLink.getParticipantId());
    }

    @Test
    public void setAge() {
        spatialViewerExternalLink.setAge("12345");
        assertEquals("12345", spatialViewerExternalLink.getAge());
    }

    @Test
    public void getProtocol() {
        spatialViewerExternalLink.setProtocol("12345");
        assertEquals("12345", spatialViewerExternalLink.getProtocol());
    }

    @Test
    public void getSampleType() {
        spatialViewerExternalLink.setSampleType("12345");
        assertEquals("12345", spatialViewerExternalLink.getSampleType());
    }

    @Test
    public void getSex() {
        spatialViewerExternalLink.setSex("12345");
        assertEquals("12345", spatialViewerExternalLink.getSex());
    }

    @Test
    public void getTissueSource() {
        spatialViewerExternalLink.setTissueSource("12345");
        assertEquals("12345", spatialViewerExternalLink.getTissueSource());
    }

    @Test
    public void getEnrollmentCategory() {
        spatialViewerExternalLink.setEnrollmentCategory("12345");
        assertEquals("12345", spatialViewerExternalLink.getEnrollmentCategory());
    }

    @Test
    public void getParticipantIdSort() {
        spatialViewerExternalLink.setRedcapId("123-4");
        assertEquals(1234, spatialViewerExternalLink.getParticipantIdSort());
    }

    @Test
    public void getImageTypeSort() {
        spatialViewerExternalLink.setImageType("AbCdEf");
        assertEquals("abcdef", spatialViewerExternalLink.getImageTypeSort());
    }        


    @Test
    public void setReleaseVersionDisplay(){
        spatialViewerExternalLink.setReleaseVersionDisplay("Recently Released");
        assertEquals("Recently Released", spatialViewerExternalLink.getReleaseVersionDisplay());
    }

    @Test
    public void setReleaseVerison(){
        Double expected = 56.0;
        spatialViewerExternalLink.setReleaseVersion(56.0);
        assertEquals(expected, spatialViewerExternalLink.getReleaseVersion());
    }

    @Test
    public void setPrimaryAdjudicatedCategory(){
        String expected = "TestCategory";
        spatialViewerExternalLink.setPrimaryAdjudicatedCategory(expected);
        assertEquals(expected, spatialViewerExternalLink.getPrimaryAdjudicatedCategory());
    }

    @Test
    public void setKdigoStage(){
        spatialViewerExternalLink.setKdigoStage("Stage 3");
        assertEquals("Stage 3 (ks)", spatialViewerExternalLink.getKdigoStage());
    }

    @Test
    public void setKdigoStage_whenBlank(){
        spatialViewerExternalLink.setKdigoStage("");
        assertEquals("", spatialViewerExternalLink.getKdigoStage());
    }

    @Test
    public void setBaselineEgfr(){
        spatialViewerExternalLink.setBaselineEgfr("60");
        assertEquals("60 (eGFR)", spatialViewerExternalLink.getBaselineEgfr());
    }

    @Test
    public void setBaselineEgfr_whenBlank() {
        spatialViewerExternalLink.setBaselineEgfr("");
        assertEquals("", spatialViewerExternalLink.getBaselineEgfr());
    }

    @Test
    public void setProteinuria(){
        spatialViewerExternalLink.setProteinuria("high");
        assertEquals("high (prot)", spatialViewerExternalLink.getProteinuria());
    }

    @Test
    public void setProteinuria_whenBlank(){
        spatialViewerExternalLink.setProteinuria("");
        assertEquals("", spatialViewerExternalLink.getProteinuria());
    }

    @Test
    public void setA1c(){
        spatialViewerExternalLink.setA1c("5.6");
        assertEquals("5.6 (a1c)", spatialViewerExternalLink.getA1c());
    }

    @Test
    public void setA1c_whenBlank(){
        spatialViewerExternalLink.setA1c("");
        assertEquals("", spatialViewerExternalLink.getA1c());
    }

    @Test
    public void setAlbuminuria(){
        spatialViewerExternalLink.setAlbuminuria("Moderate");
        assertEquals("Moderate (alb)", spatialViewerExternalLink.getAlbuminuria());
    }

    @Test
    public void setAlbuminuria_whenBlank(){
        spatialViewerExternalLink.setAlbuminuria("");
        assertEquals("", spatialViewerExternalLink.getAlbuminuria());
    }

    @Test
    public void setDiabetesHistory(){
        spatialViewerExternalLink.setDiabetesHistory("Don't Know");
        assertEquals("Don't Know (dh)", spatialViewerExternalLink.getDiabetesHistory());
    }

    @Test
    public void setDiabetesHistory_whenBlank(){
        spatialViewerExternalLink.setDiabetesHistory("");
        assertEquals("", spatialViewerExternalLink.getDiabetesHistory());
    }

    @Test
    public void setDiabetesDuration(){
        spatialViewerExternalLink.setDiabetesDuration("10 years");
        assertEquals("10 years (dd)", spatialViewerExternalLink.getDiabetesDuration());
    }

    @Test
    public void setDiabetesDuration_whenBlank(){
        spatialViewerExternalLink.setDiabetesDuration("");
        assertEquals("", spatialViewerExternalLink.getDiabetesDuration());
    }

    @Test
    public void setHypertensionHistory(){
        spatialViewerExternalLink.setHypertensionHistory("Don't Know");
        assertEquals("Don't Know (hh)", spatialViewerExternalLink.getHypertensionHistory());
    }

    @Test
    public void setHypertensionHistory_whenBlank(){
        spatialViewerExternalLink.setHypertensionHistory("");
        assertEquals("", spatialViewerExternalLink.getHypertensionHistory());
    }

    @Test
    public void setHypertensionDuration(){
        spatialViewerExternalLink.setHypertensionDuration("5 years");
        assertEquals("5 years (hd)", spatialViewerExternalLink.getHypertensionDuration());
    }

    @Test
    public void setHypertensionDuration_whenBlank(){
        spatialViewerExternalLink.setHypertensionDuration("");
        assertEquals("", spatialViewerExternalLink.getHypertensionDuration());
    }

    @Test
    public void setOnRaasBlockade(){
        spatialViewerExternalLink.setOnRaasBlockade("yes");
        assertEquals("yes (rb)", spatialViewerExternalLink.getOnRaasBlockade());
    }

    @Test
    public void setOnRaasBlockade_whenBlank(){
        spatialViewerExternalLink.setOnRaasBlockade("");
        assertEquals("", spatialViewerExternalLink.getOnRaasBlockade());
    }

    @Test
    public void setRace(){
        String expected = "Asian";
        spatialViewerExternalLink.setRace(expected);
        assertEquals(expected, spatialViewerExternalLink.getRace());
    }


}

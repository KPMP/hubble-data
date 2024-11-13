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
        String expected = "Stage 3";
        spatialViewerExternalLink.setKdigoStage(expected);
        assertEquals(expected, spatialViewerExternalLink.getKdigoStage());
    }

    @Test
    public void setBaselineEgfr(){
        String expected = "60";
        spatialViewerExternalLink.setBaselineEgfr(expected);
        assertEquals(expected, spatialViewerExternalLink.getBaselineEgfr());
    }

    @Test
    public void setProteinuria(){
        String expected = "High";
        spatialViewerExternalLink.setProteinuria(expected);
        assertEquals(expected, spatialViewerExternalLink.getProteinuria());
    }

    @Test
    public void setA1c(){
        String expected = "5.6";
        spatialViewerExternalLink.setA1c(expected);
        assertEquals(expected, spatialViewerExternalLink.getA1c());
    }

    @Test
    public void setAlbuminuria(){
        String expected = "Moderate";
        spatialViewerExternalLink.setAlbuminuria(expected);
        assertEquals(expected, spatialViewerExternalLink.getAlbuminuria());
    }

    @Test
    public void setDiabetesHistory(){
        String expected = "Don'T KnOw";
        spatialViewerExternalLink.setDiabetesHistory(expected);
        assertEquals("Don't Know", spatialViewerExternalLink.getDiabetesHistory());
    }

    @Test
    public void setDiabetesDuration(){
        String expected = "10 years";
        spatialViewerExternalLink.setDiabetesDuration(expected);
        assertEquals(expected, spatialViewerExternalLink.getDiabetesDuration());
    }

    @Test
    public void setHypertensionHistory(){
        String expected = "Don'T KNOW";
        spatialViewerExternalLink.setHypertensionHistory(expected);
        assertEquals("Don't Know", spatialViewerExternalLink.getHypertensionHistory());
    }

    @Test
    public void setHypertensionDuration(){
        String expected = "5 years";
        spatialViewerExternalLink.setHypertensionDuration(expected);
        assertEquals(expected, spatialViewerExternalLink.getHypertensionDuration());
    }

    @Test
    public void setOnRaasBlockade(){
        String expected = "Yes";
        spatialViewerExternalLink.setOnRaasBlockade(expected);
        assertEquals(expected, spatialViewerExternalLink.getOnRaasBlockade());
    }

    @Test
    public void setRace(){
        String expected = "Asian";
        spatialViewerExternalLink.setRace(expected);
        assertEquals(expected, spatialViewerExternalLink.getRace());
    }


}

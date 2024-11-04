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

}

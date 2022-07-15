package org.kpmp.spatialViewerDataset;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileLinkTest {

    private SpatialViewerExternalLinkDataset spatialViewerExternalLink;

    @Before
    public void setUp() throws Exception {
        spatialViewerExternalLink = new SpatialViewerExternalLinkDataset();
    }

    @After
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
    public void getTissueType() {
        spatialViewerExternalLink.setTissueType("12345");
        assertEquals("12345", spatialViewerExternalLink.getTissueType());
    }
}

package org.kpmp.spatialViewerDataset;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileLinkTest {

    private FileLink fileLink;

    @Before
    public void setUp() throws Exception {
        fileLink = new FileLink();
    }

    @After
    public void tearDown() throws Exception {
        fileLink = null;
    }

    @Test
    public void setExternalLink() {
        fileLink.setExternalLink("12345");
        assertEquals("12345", fileLink.getExternalLink());
    }

    @Test
    public void setConfigType() {
        fileLink.setConfigType("12345");
        assertEquals("12345", fileLink.getConfigType());
 
    }

    @Test
    public void setImageType() {
        fileLink.setImageType("12345");
        assertEquals("12345", fileLink.getImageType());
    }

    @Test
    public void setDataType() {
        fileLink.setDataType("12345");
        assertEquals("12345", fileLink.getDataType());
    }

    @Test
    public void setSpectrackSampleId() {
        fileLink.setSpectrackSampleId("12345");
        assertEquals("12345", fileLink.getSpectrackSampleId());
    }

    @Test
    public void setRedcapId() {
        fileLink.setRedcapId("12345");
        assertEquals("12345", fileLink.getRedcapId());
    }

    @Test
    public void setParticipantId() {
        fileLink.setParticipantId(12345);
        assertEquals(12345, fileLink.getParticipantId());
    }

    @Test
    public void setAge() {
        fileLink.setAge("12345");
        assertEquals("12345", fileLink.getAge());
    }

    @Test
    public void getProtocol() {
        fileLink.setProtocol("12345");
        assertEquals("12345", fileLink.getProtocol());
    }

    @Test
    public void getSampleType() {
        fileLink.setSampleType("12345");
        assertEquals("12345", fileLink.getSampleType());
    }

    @Test
    public void getSex() {
        fileLink.setSex("12345");
        assertEquals("12345", fileLink.getSex());
    }

    @Test
    public void getTissueSource() {
        fileLink.setTissueSource("12345");
        assertEquals("12345", fileLink.getTissueSource());
    }

    @Test
    public void getTissueType() {
        fileLink.setTissueType("12345");
        assertEquals("12345", fileLink.getTissueType());
    }
}

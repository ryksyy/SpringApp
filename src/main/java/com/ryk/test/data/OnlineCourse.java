package com.ryk.test.data;

public class OnlineCourse extends Course{
    private String zoomLink = "";
    private String recordingLink = "";

    public OnlineCourse(String zoomLink, String recordingLink) {
        this.zoomLink = zoomLink;
        this.recordingLink = recordingLink;
        createId();
    }

    public String getZoomLink() {
        return this.zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }

    public String getRecordingLink() {
        return this.recordingLink;
    }

    public void setRecordingLink(String recordingLink) {
        this.recordingLink = recordingLink;
    }

}

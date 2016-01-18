package com.npixels.mockingjay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileDTO {

    private String id;


    private String fileName;
    private Map extendedMetadata;
    private int sequenceNumber;

    public FileDTO()
    {
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    public Map getExtendedMetadata()
    {
        return extendedMetadata;
    }

    public void setExtendedMetadata(Map extendedMetadata)
    {
        this.extendedMetadata = extendedMetadata;
    }


    @Override
    public String toString() {
        return "FileDTO{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", extendedMetadata=" + extendedMetadata +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}

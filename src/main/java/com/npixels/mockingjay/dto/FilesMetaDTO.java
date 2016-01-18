package com.npixels.mockingjay.dto;

import java.util.HashMap;
import java.util.Map;

public class FilesMetaDTO {
    private Map<String,Object> newMetadata = new HashMap<String, Object>();

    public Map<String, Object> getNewMetadata() {
        return newMetadata;
    }

    public void setNewMetadata(Map<String, Object> newMetadata) {
        this.newMetadata = newMetadata;
    }

}

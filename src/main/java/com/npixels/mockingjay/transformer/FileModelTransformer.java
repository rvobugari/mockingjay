package com.npixels.mockingjay.transformer;


import com.npixels.mockingjay.dto.FilesDTO;
import com.npixels.mockingjay.exception.JsonTransformationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


@Component
public class FileModelTransformer {

    public FilesDTO toFilesDTO(String json) {
        FilesDTO data;
        try {
            data = new ObjectMapper().readValue(json, FilesDTO.class);
        } catch (Exception e) {
            throw new JsonTransformationException("Failed to parse JSON: '" + json + "'", e);
        }

        return data;
    }
}

package IO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Word;

import java.io.*;
import java.util.List;

public class IOProcessor implements IO {

    public List<Word> readObjectsFromJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            return objectMapper.readValue(new File("movni.json"), new TypeReference<List<Word>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


package Service;

import IO.IO;
import IO.IOProcessor;
import models.Word;

import java.util.List;

public class Service {
    private IO io = new IOProcessor();
    private List<Word> list;
    private int id = 0;

    public Service() {
        list = io.readObjectsFromJSON();
    }

    public Word getWordById(int id){
        if (id >= 0 && id < list.size()){
            this.id = id;
            return list.get(id);
        }
        return null;
    }

    public Word next() {
        if (id < list.size()-1) {
            id++;
            return list.get(id);
        }
        return null;
    }

    public Word previous(){
        if (id > 0) {
            id--;
            return list.get(id);
        }
        return null;
    }

    public int id() {
        return id;
    }
}

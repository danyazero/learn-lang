package Service;


import models.Word;

import java.util.List;

public class Service {
    private int id = 0;

    public Service() {}

    public Word getWordById(List<Word> list, int id){
        if (id >= 0 && id < list.size()){
            this.id = id;
            return list.get(id);
        }
        return null;
    }

    public Word next(List<Word> list) {
        if (id < list.size()-1) {
            id++;
            return list.get(id);
        }
        return null;
    }

    public Word previous(List<Word> list){
        if (id > 0) {
            id--;
            return list.get(id);
        }
        return null;
    }
    public void setId(int id){
        this.id = id;
    }

    public int id() {
        return id;
    }
}

package Service;

import IO.IO;
import models.Word;

import java.util.List;
import IO.IOProcessor;

public class InterLayerService {
    boolean reverseLangs = false;
    boolean isRandom = false;
    private List<Word> list;
    private IO io = new IOProcessor();
    Service usualOrderService = new Service();
    RandomOrderService randomOrderService;

    public InterLayerService() {
        list = io.readObjectsFromJSON();
    }

    public void createRandomOrder(int start, int end){
        randomOrderService = new RandomOrderService(start, end);
    }

    public Word next(){
        if (isRandom){
            return randomOrderService.next(list);
        }else {
            return usualOrderService.next(list);
        }
    }

    public Word previous(){
        if (isRandom){
            return randomOrderService.previous(list);
        }else {
            return usualOrderService.previous(list);
        }
    }

    public Word getWordById(int id){
        if (isRandom) {
            return randomOrderService.getWordById(list, id);
        }else return usualOrderService.getWordById(list, id);
    }

    public int id(){
        if (isRandom) {
            return randomOrderService.id();
        }else return usualOrderService.id();
    }

    public void isRandom(boolean isRandom){
        usualOrderService.setId(randomOrderService.id());
        this.isRandom = isRandom;
    }
}

package Service;

import models.Word;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomOrderService {
    private List<Integer> randomArray;
    int size = 0;
    private int id;

    public RandomOrderService(int start, int end){
        size = end - start;
        randomArray = IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomArray);
    }

    public Word next(List<Word> list) {
        id++;
        return getWord(list);
    }

    public Word previous(List<Word> list) {
        id--;
        return getWord(list);
    }

    private Word getWord(List<Word> list) {
        if (id >= 0 && id <= size){
            int wordId = randomArray.get(id);
            System.out.print(wordId + " ");
            return list.get(wordId);
        }else {
            Collections.shuffle(randomArray);
            id = 0;
            return list.get(id);
        }
    }

    public Word getWordById(List<Word> list, int id){
        if (id >= 0 && id <= list.size()){
            this.id = id;
            int wordId = randomArray.get(id);
            return list.get(wordId);
        }
        return null;
    }

    public int id(){
        return randomArray.get(id);
    }
}

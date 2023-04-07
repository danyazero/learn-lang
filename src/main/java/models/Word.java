package models;

public class Word {
    private String english;
    private String translate;

    public Word(String english, String translate){
        this.english = english;
        this.translate = translate;
    }

    public Word(){

    }
    public String getEnglish() {
        return english;
    }
    public String getTranslate() {
        return translate;
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[").append(getFirstForm()).append(", ").append(getSecondForm()).append(", ").append(getThirdForm()).append("] ").append(getTranslate()).append("\n");
//        return sb.toString();
//    }
}

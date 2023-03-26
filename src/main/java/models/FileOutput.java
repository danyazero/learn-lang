package models;

public class FileOutput {
    private String firstForm;
    private String secondForm;
    private String thirdForm;
    private String translate;

    public FileOutput(String firstForm, String secondForm, String thirdForm, String translate){
        this.firstForm = firstForm;
        this.secondForm = secondForm;
        this.thirdForm = thirdForm;
        this.translate = translate;
    }

    public FileOutput(){

    }

    public String getFirstForm() {
        return firstForm;
    }

    public void setFirstForm(String firstForm) {
        this.firstForm = firstForm;
    }

    public String getSecondForm() {
        return secondForm;
    }

    public void setSecondForm(String secondForm) {
        this.secondForm = secondForm;
    }

    public String getThirdForm() {
        return thirdForm;
    }

    public void setThirdForm(String thirdForm) {
        this.thirdForm = thirdForm;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[").append(getFirstForm()).append(", ").append(getSecondForm()).append(", ").append(getThirdForm()).append("] ").append(getTranslate()).append("\n");
//        return sb.toString();
//    }
}

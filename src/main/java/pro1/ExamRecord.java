package pro1;

import java.lang.Math;

public class ExamRecord {

    private String name;
    private Fraction score;

    public ExamRecord(String name, Fraction score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public Fraction getScore() {
        return score;
    }
}

package ai.fooz.models;

import com.orm.SugarRecord;

import java.util.Date;

public class Prediction extends SugarRecord {
    public String title;
    public String confidence;
    public Integer calories;
    public Integer carbs;
    public Integer fats;
    public Integer proteins;
    public Boolean isSelected;
    public RefImage refimage;

    public Prediction() {

    }
}

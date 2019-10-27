package ai.fooz.models;

import android.media.Image;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

public class RefImage extends SugarRecord {
    public String name;
    public String timestamp;

    public RefImage() {

    }

    public RefImage(String name) {
        this.name = name;
    }

    public List<Prediction> getPredictions(){
        return Prediction.find(Prediction.class, "refimage = ?", getId().toString());
    }

    public int getSelectedPredPosition(){
        int spos = 0;
        List<Prediction> ls = getPredictions();
        for(int i=0;i<ls.size();i++){
            Prediction pd = ls.get(i);
            if(pd.isSelected){
                spos = i;
                break;
            }
        }
        return spos;
    }
//
//    public void setPredictions(List<Prediction> predictions) {
//
//        return Prediction.find(Prediction.class, "refimage = ?", getId().toString());
//    }
}

package ai.fooz.foodanalysis.customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Fijitsu on 8/21/2017.
 */

public class ButtonRegular extends Button {
    public ButtonRegular(Context context) {
        super(context);
        setassets(context);
    }

    public ButtonRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setassets(context);
    }

    public ButtonRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setassets(context);
    }

    public ButtonRegular(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        setassets(context);
    }

    private void setassets(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Font/Lato-Regular.ttf"));



    }
}

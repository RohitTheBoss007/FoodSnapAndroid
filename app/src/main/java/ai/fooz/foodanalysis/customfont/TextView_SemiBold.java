package ai.fooz.foodanalysis.customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Fijitsu on 8/21/2017.
 */

public class TextView_SemiBold extends TextView {
    public TextView_SemiBold(Context context) {
        super(context);
        setassets(context);
    }

    public TextView_SemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setassets(context);
    }

    public TextView_SemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setassets(context);
    }

    public TextView_SemiBold(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        setassets(context);
    }

    private void setassets(Context context) {

        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "Font/Lato-Semibold.ttf"));


    }
}

package com.happyfresh.showcase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.example.guidesingleview.R;


public class GuideMessageView extends LinearLayout {

    private Paint mPaint;
    private RectF mRect;

    public TextView mTitleTextView;
    public TextView mContentTextView;
    public Button okButton;
    public Button NoButton;

    public LinearLayout childContentButton;
    private LinearLayout childContent;
    public int padding = 0;
    public int paddingBetween = 0;

    public String buttonText = "";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    GuideMessageView(Context context) {
        super(context);

        float density = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        setOrientation(VERTICAL);

        mRect = new RectF();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        padding = (int) (10 * density);
        paddingBetween = (int) (3 * density);

        childContent = new LinearLayout(context);
        childContent.setOrientation(VERTICAL);
        mTitleTextView = new TextView(context);
        mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        mTitleTextView.setTextColor(Color.BLACK);
        mTitleTextView.setTypeface(mTitleTextView.getTypeface(), Typeface.BOLD);
        childContent.addView(mTitleTextView);


        mContentTextView = new TextView(context);
        mContentTextView.setTextColor(Color.BLACK);
        mContentTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        childContent.addView(mContentTextView);
        addView(childContent, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        childContentButton = new LinearLayout(context);
        childContentButton.setOrientation(HORIZONTAL);
        childContentButton.setGravity(Gravity.CENTER);



        NoButton = new Button(context);
        NoButton.setText("رد کردن آموزش");
        NoButton.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        NoButton.setTextColor(Color.BLACK);
        NoButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
        NoButton.setGravity(Gravity.CENTER);
        NoButton.setBackground(ContextCompat.getDrawable(context, R.drawable.ignore_edu));
        LayoutParams paramsn = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        paramsn.setMargins(20, 0, 20, 0);
        NoButton.setLayoutParams(paramsn);
        childContentButton.addView(NoButton);

        okButton = new Button(context);
        okButton.setText(buttonText);
        okButton.setTextAlignment(TEXT_ALIGNMENT_GRAVITY);
        okButton.setTextColor(Color.WHITE);
        okButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
        okButton.setGravity(Gravity.CENTER);

        okButton.setBackground(ContextCompat.getDrawable(context, R.drawable.next_edu));
        childContentButton.addView(okButton);
        LayoutParams paramso = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
     paramso.setMargins(20, 0, 20, 0);
     okButton.setLayoutParams(paramso);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT );
        params.setMargins(convertDp(10), convertDp(10), convertDp(10), convertDp(10));

        addView(childContentButton, params);
      //  addView(NoButton, paramsNo);
//       NoButton.setTypeface(FontUtil.getInstance(App.myContext).getRegularFont());  set font
//       okButton.setTypeface(FontUtil.getInstance(App.myContext).getRegularFont());
okButton.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
      NoButton.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

    }

    public void setTitle(String title) {
        if (title == null) {
            removeView(mTitleTextView);
            return;
        }
        mTitleTextView.setText(title);
    }


    public void setContentText(String content) {
        mContentTextView.setText(content);
    }

    public void setContentSpan(Spannable content) {
        mContentTextView.setText(content);
    }

    public void setContentTypeFace(Typeface typeFace) {
        mContentTextView.setTypeface(typeFace);
    }

    public void setTitleTypeFace(Typeface typeFace) {
        mTitleTextView.setTypeface(typeFace);
    }

    public void setTitleTextSize(int size) {
        mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setContentTextSize(int size) {
        mContentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setColor(int color) {

        mPaint.setAlpha(255);
        mPaint.setColor(color);

        invalidate();
    }

    int location[] = new int[2];

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        this.getLocationOnScreen(location);


        mRect.set(getPaddingLeft(),
                getPaddingTop(),
                getWidth() - getPaddingRight(),
                getHeight() - getPaddingBottom());


        canvas.drawRoundRect(mRect, 15, 15, mPaint);
    }

    private int convertDp(int margin){
        int marginInDp = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, margin, getResources()
                .getDisplayMetrics());

        return marginInDp;
    }
}

package com.example.zhaoting.qiandao.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.entity.novel.NovelInfo;
import com.example.zhaoting.qiandao.utils.Utils;

/**
 * Created by zhaoting on 16/2/23.
 */
public class SmallTagImage extends View {
    //图片的Bitmap
    private Bitmap imageBitmap;
    //蒙板的颜色
    private int imageMengColor;
    //title文字
    private String titleText;
    //title文字大小
    private int titleTextSize;
    //title文字颜色
    private int titleTextColor;
    //横线的颜色
    private int lineBackGround;
    //横线距离左侧的距离
    private int lineMarginLeft;
    //横线距离右侧的距离
    private int lineMarginRight;
    //sub文字
    private String subText;
    //sub文字大小
    private int subTextSize;
    //sub文字颜色
    private int subTextColor;

    //控件用的Paint
    private Paint paint;
    //用来界定控件中不同部分的绘制区域
    private Rect rect;
    //宽度和高度的最小值
    private static final int MIN_SIZE = 12;
    //用于获取字体的高度和宽度
    private Rect mBounds;

    private Context mContext;

    public SmallTagImage(Context context) {
        this(context, null);
    }

    public SmallTagImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmallTagImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SmallTagImage, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SmallTagImage_imageSrc:
                    imageBitmap = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;
                case R.styleable.SmallTagImage_imageMengColor:
                    imageMengColor = a.getColor(attr, Color.TRANSPARENT);//默认透明背景
                    break;
                case R.styleable.SmallTagImage_titleText:
                    titleText = a.getString(attr);
                    break;
                case R.styleable.SmallTagImage_titleTextSize:
                    titleTextSize = a.getDimensionPixelSize(
                            attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));//默认标题字体大小是16sp
                    break;
                case R.styleable.SmallTagImage_titleTextColorS:
                    titleTextColor = a.getColor(attr, 0x00000000);//默认黑色字体
                    break;
                case R.styleable.SmallTagImage_subText:
                    subText = a.getString(attr);
                    break;
                case R.styleable.SmallTagImage_subTextColor:
                    subTextColor = a.getColor(attr, 0x00000000);//默认黑色字体
                    break;
                case R.styleable.SmallTagImage_subTextSize:
                    subTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics()));//默认sub字体大小是14sp
                    break;
                case R.styleable.SmallTagImage_lineBackGround:
                    lineBackGround = a.getColor(attr, Color.TRANSPARENT);//默认透明背景
                    break;
                case R.styleable.SmallTagImage_lineMarginLeft:
                    lineMarginLeft = a.getDimensionPixelSize(attr, 0);
                    break;
                case R.styleable.SmallTagImage_lineMarginRight:
                    lineMarginRight = a.getDimensionPixelSize(attr, 0);
                    break;
            }
        }
        a.recycle();

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rect = new Rect();
        mBounds = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        rect.left = getPaddingLeft();
        rect.top = getPaddingTop();
        rect.right = getWidth() - getPaddingRight();
        rect.bottom = getHeight() - getPaddingBottom();
        if (imageBitmap != null) {
            canvas.drawBitmap(imageBitmap, null, rect, paint);
        }
        paint.setColor(imageMengColor);
        canvas.drawRect(rect, paint);

        int startX = rect.left + lineMarginLeft;
        int stopX = rect.right - lineMarginRight;
        paint.setColor(lineBackGround);
        canvas.drawLine(startX, getHeight() / 2, stopX, getHeight() / 2, paint);

        if (titleText != null) {
            paint.setTextSize(titleTextSize);
            paint.setColor(titleTextColor);

            paint.getTextBounds(titleText, 0, titleText.length(), mBounds);

            float textWidth = mBounds.width();
            float textHeight = mBounds.height();
            float x = getWidth() / 2 - textWidth / 2;
            float y = getHeight() / 2 - textHeight + 15;
            canvas.drawText(titleText, x, y, paint);
        }
        if (subText != null) {
            paint.setTextSize(subTextSize);
            paint.setColor(subTextColor);

            paint.getTextBounds(subText, 0, subText.length(), mBounds);

            float textWidth = mBounds.width();
            float textHeight = mBounds.height();
            float x = getWidth() / 2 - textWidth / 2;
            float y = getHeight() / 2 + textHeight + 8;
            canvas.drawText(subText, x, y, paint);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            int desired = getPaddingLeft() + getPaddingRight();
            desired += (imageBitmap != null) ? imageBitmap.getWidth() : 0;
            width = Math.max(MIN_SIZE, desired);
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(desired, widthSize);
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int desired = getPaddingTop() + getPaddingBottom();
            desired += (imageBitmap != null) ? imageBitmap.getHeight() : 0;
            height = Math.max(MIN_SIZE, desired);
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(desired, heightSize);
            }
        }
        setMeasuredDimension(width, height);
    }

    public void setData(final NovelInfo info) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                imageBitmap = (Bitmap) msg.obj;
                titleText = info.getTitle();
                subText = String.valueOf(info.getGuid());
                requestLayout();
                invalidate();
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = Utils.urlToBitmap(info.getBanner());
                Message message = new Message();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }).start();

    }

    public void setImageMengColor(int color) {
        imageMengColor = color;
        requestLayout();
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap) {
        imageBitmap = bitmap;
        requestLayout();
        invalidate();
    }

    public void setImageUrl(final String url) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                imageBitmap = (Bitmap) msg.obj;
                setImageBitmap(imageBitmap);
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = Utils.urlToBitmap(url);
                Message message = new Message();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }).start();
    }

    public void setImageDrawable(int drawable) {
        Drawable d = mContext.getResources().getDrawable(drawable);
        BitmapDrawable bd = (BitmapDrawable) d;
        Bitmap bitmap = bd.getBitmap();
        setImageBitmap(bitmap);
    }

    public void setTitleText(String text) {
        titleText = text;
        requestLayout();
        invalidate();
    }

    public void setTitleTextColor(int textColor) {
        titleTextColor = textColor;
        requestLayout();
        invalidate();
    }

    public void setTitleTextSize(int textSize) {
        titleTextSize = textSize;
        requestLayout();
        invalidate();
    }

    public void setSubText(String text) {
        subText = text;
        requestLayout();
        invalidate();
    }

    public void setSubTextColor(int subColor) {
        subTextColor = subColor;
        requestLayout();
        invalidate();
    }

    public void setSubTextSize(int subSize) {
        subTextSize = subSize;
        requestLayout();
        invalidate();
    }

    public void setLineBackground(int background) {
        lineBackGround = background;
        requestLayout();
        invalidate();
    }

    public void setLineMarginLeft(int marginLeft) {
        lineMarginLeft = marginLeft;
        requestLayout();
        invalidate();
    }

    public void setLineMarginRight(int marginRight) {
        lineMarginRight = marginRight;
        requestLayout();
        invalidate();
    }
}



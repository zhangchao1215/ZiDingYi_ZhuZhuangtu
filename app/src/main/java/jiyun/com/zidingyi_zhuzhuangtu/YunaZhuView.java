package jiyun.com.zidingyi_zhuzhuangtu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/17 15:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class YunaZhuView extends View {
    private int mShouSuoYaColor;//收缩压的颜色
    private int mShuZhangYaColor;//舒张压的颜色
    private String mSHhouSuotext;//第一个圆柱的名字
    private String mShuZhangtext;//第二个圆柱的名字
    private int textSize;        //底部字体的大小
    private Context mContext;   //上下文对象
    private int mWindowWidth;  //屏幕宽
    private int mWindowHeight;//屏幕高
    //view宽
    private int mViewWidth;
    //view高
    private int mViewHeight;
    //左边距
    private int mMarginLeft;
    //上边距
    private int mMarginTop;
    //收缩压画笔
    private Paint mShouSuoYaPaint;
    //舒张压画笔
    private Paint mShuZhangYaPaint;
    //线和下方字体画笔
    private Paint mLinePaint;
    //上方画笔
    private Paint mTopPaint;
    private float mDiBuHeight;
    private int mShuZhangYaCl;
    private int mShouSuoYaCl;
    private float mShuZhangYatop;
    private float mShouSuoYatop;

    /**
     * 类中动态创建
     *
     * @param context
     */
    public YunaZhuView(Context context) {
        this(context, null);
    }

    /**
     * 在布局中创建
     *
     * @param context
     * @param attrs
     */
    public YunaZhuView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 在布局和类中创建
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public YunaZhuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.yuanzhu);
//        mShouSuoYaColor = typedArray.getColor(R.styleable.yuanzhu_ColorShouSUoYa, 000000);
//        mShuZhangYaColor = typedArray.getColor(R.styleable.yuanzhu_ColorShuZhangYa, 000000);
//        mSHhouSuotext = typedArray.getString(R.styleable.yuanzhu_textshousuo);
//        mShuZhangtext = typedArray.getString(R.styleable.yuanzhu_textshuzhang);
//        textSize = typedArray.getInt(R.styleable.yuanzhu_textsizeshuzhang, 50);
//        typedArray.recycle();
        mContext = context;
        mDiBuHeight = 50;
        mWindowHeight = DimenUtils.getScreenHeight();

        mWindowWidth = DimenUtils.getScreenWidth();

        mViewHeight = mWindowHeight / 2+100;

        mViewWidth = mWindowWidth / 8;

        mMarginLeft = (mWindowWidth - mViewWidth * 3) / 2;

        mMarginTop = mViewHeight;
        mShuZhangYaCl = 0;
        mShouSuoYaCl = 0;

        mShuZhangYatop = mViewHeight;
        mShouSuoYatop = mViewHeight;

        mShouSuoYaPaint = new Paint();
        Log.e("TAG", mShouSuoYaColor + "");
        mShouSuoYaPaint.setColor(mShouSuoYaColor);


        mShuZhangYaPaint = new Paint();
        mShuZhangYaPaint.setColor(mShuZhangYaColor);


        mLinePaint = new Paint();
        mLinePaint.setColor(Color.parseColor("#000000"));
        mLinePaint.setTextSize(textSize);


        mTopPaint = new Paint();
        mTopPaint.setTextSize(30);
        mTopPaint.setColor(Color.parseColor("#969696"));


    }

    /**
     * 用来画view的方法
     *
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画一条线
        canvas.drawLine(0, mViewHeight, mWindowWidth, mViewHeight, mLinePaint);
        //画两个柱子
        canvas.drawRect(mMarginLeft, mShouSuoYatop, mMarginLeft + mViewWidth, mViewHeight, mShouSuoYaPaint);
        canvas.drawRect(mMarginLeft + mViewWidth * 2, mShuZhangYatop, mMarginLeft + mViewWidth * 2 + mViewWidth, mViewHeight, mShuZhangYaPaint);
        //文本的宽度
        float v = mLinePaint.measureText(mSHhouSuotext);
        //文字view的宽度减去文字所占的宽度 除以2得到 文字view的x轴 加上marginLeft
        float x1 = (mViewWidth - v) / 2 + mMarginLeft;
        //得到文字的高度
        Paint.FontMetrics fontMetrics = mLinePaint.getFontMetrics();
        //(Math.abs(fontMetrics.ascent) - Math.abs(fontMetrics.descent))得到一个高度的平均值
        //文字viewgaodu减去文字高度 除以2 得到y轴
        float y1 = ((mDiBuHeight - (Math.abs(fontMetrics.ascent) - Math.abs(fontMetrics.descent))) / 2) + mViewHeight;
        canvas.drawText(mSHhouSuotext, x1, y1, mLinePaint);
        float v1 = mLinePaint.measureText(mShuZhangtext);
        float x2 = (mViewWidth - v1) / 2 + mMarginLeft + mViewWidth * 2;
        canvas.drawText(mShuZhangtext, x2, y1, mLinePaint);

        float v3 = mLinePaint.measureText(String.valueOf(mShuZhangYaCl));
        float x3 = (mViewWidth - v3) / 2 + mMarginLeft + mViewWidth * 2;
        canvas.drawText(String.valueOf(mShuZhangYaCl), x3, mShuZhangYatop - 10, mTopPaint);
        Log.e("TAGN", "值----"+(mShuZhangYatop - 10));
        float v4 = mLinePaint.measureText(String.valueOf(mShouSuoYaCl));
        float x4 = (mViewWidth - v4) / 2 + mMarginLeft;
        canvas.drawText(String.valueOf(mShouSuoYaCl), x4, mShouSuoYatop - 10, mTopPaint);
    }

    /**
     * 用来测量的
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setData(int shousuoya, int shuzhangya) {
        float shousuobili = (float) (shousuoya / 200.0);
        float shuzhangbili = (float) (shuzhangya / 200.0);
        mShouSuoYatop = mViewHeight-shousuobili * mViewHeight;
        mShuZhangYatop =  mViewHeight-shuzhangbili * mViewHeight;
        mShuZhangYaCl = shuzhangya;
        mShouSuoYaCl = shousuoya;
        invalidate();
    }
}

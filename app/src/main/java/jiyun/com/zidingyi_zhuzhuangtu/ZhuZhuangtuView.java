package jiyun.com.zidingyi_zhuzhuangtu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/17 14:59
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ZhuZhuangtuView extends View {
    private int mShouSuoColor;
    private int mShuZhangColor;
    private String mShouSuoText;
    private String mShuZhangText;
    private int size;
    private Context context;
    private int mWindowidth; //屏幕的宽高
    private int mWindowHeight;

    //view 的宽高
    private int mViewidth;
    private int mViewHeight;

    //左上边距
    private int marginLeft;
    private int marginTop;
    private float mDiBuHeight;


    //画笔
    private Paint YuanZhupaint;//圆柱画笔
    //线和下方字体画笔
    private Paint TextPaint;
    //上方画笔
    private Paint mTopPaint;
    //收缩压画笔
    private Paint ShouSuoYapain;
    //伸张压画笔
    private Paint ShenZhangYaPaint;
    private int mShuZhangYaC1;
    private int mShenSuoYaC1;


    private float mShenZhangYaTop;
    private float mShouSuoYaTop;

    /**
     * 类中动态创建
     *
     * @param context
     */

    public ZhuZhuangtuView(Context context) {
        this(context, null);


    }

    /**
     * 布局中创建
     *
     * @param context
     * @param attrs
     */
    public ZhuZhuangtuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 布局，类中创建
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ZhuZhuangtuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);


    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.YuanZhu);

        mShouSuoColor = typedArray.getColor(R.styleable.YuanZhu_ColorShouSuo, 000);
        mShuZhangColor = typedArray.getColor(R.styleable.YuanZhu_ColorShuZhang, 000);

        mShouSuoText = typedArray.getString(R.styleable.YuanZhu_TextShouSuo);
        mShuZhangText = typedArray.getString(R.styleable.YuanZhu_TextShuZhang);
        size = typedArray.getInt(R.styleable.YuanZhu_TextSizeshuzhang, 50);

        //通过工具类获得这个整体屏幕的宽高
        mWindowHeight = DimenUtils.getScreenHeight();
        mWindowidth = DimenUtils.getScreenWidth();

        //我这个view的宽度是整体的八分之一
        mViewidth = mWindowidth / 8;
        //高度是整体的二分之一
        mViewHeight = mWindowHeight / 2;

        marginLeft = (mWindowidth - mViewidth * 3) / 2;
        //上边距等于整个view的高度
        marginTop = mViewHeight;

        ShouSuoYapain = new Paint();
        ShouSuoYapain.setColor(mShouSuoColor);

        ShenZhangYaPaint = new Paint();
        ShenZhangYaPaint.setColor(mShuZhangColor);

        TextPaint = new Paint();
        TextPaint.setTextSize(size);

        mTopPaint = new Paint();
        mTopPaint.setTextSize(60);

        YuanZhupaint = new Paint();
        mDiBuHeight = 50;

        mShenSuoYaC1 = 0;
        mShuZhangYaC1 = 0;

        mShenZhangYaTop = mViewHeight;
        mShouSuoYaTop = mViewHeight;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, mViewHeight, mWindowidth, mViewHeight, TextPaint);

        //画左边的圆柱
        canvas.drawRect(marginLeft, mShenZhangYaTop, marginLeft + mViewidth, mViewHeight, ShouSuoYapain);

        //画右边的圆柱
        canvas.drawRect(marginLeft + mViewidth * 2, mShouSuoYaTop, marginLeft + mViewidth * 3, mViewHeight, ShenZhangYaPaint);


        //柱状图下面的文本内容
        //获得文本的宽度
        float v = TextPaint.measureText(mShouSuoText);
        //得到点 X轴的坐标点
        float x = (mViewidth - v) / 2 + marginLeft;
        Paint.FontMetrics fontMetrics = TextPaint.getFontMetrics();
        float y1 = ((mDiBuHeight - (Math.abs(fontMetrics.ascent) - Math.abs(fontMetrics.descent))) / 2) + mViewHeight;
        canvas.drawText(mShouSuoText, x, y1, TextPaint);

        float v1 = TextPaint.measureText(mShuZhangText);
        //得到X轴坐标点
        float x1 = (mViewidth - v1) / 2 + marginLeft + mViewidth * 2;

        canvas.drawText(mShuZhangText, x1, y1, TextPaint);


        //柱状图图顶部的数字
        float v3 = TextPaint.measureText(String.valueOf(mShenSuoYaC1));

        //得到X轴的坐标点
        float x3 = (mViewidth - v3) / 2 + marginLeft;

        canvas.drawText(String.valueOf(mShenSuoYaC1), x3, mShenZhangYaTop - 10, TextPaint);

        float v4 = TextPaint.measureText(String.valueOf(mShuZhangYaC1));

        float x4 = (mViewidth - v4) / 2 + marginLeft + mViewidth * 2;

        canvas.drawText(String.valueOf(mShuZhangYaC1), x4, mShouSuoYaTop - 10, TextPaint);
        Log.d("ZhuZhuangtuView", "(mShenZhangYaTop-10  值---):" + (mShenZhangYaTop - 10));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    public void setDate(int shuzhang, int shensuo) {
        float shensuobili = (float) (shuzhang / 200.0);
        float shuzhangbii = (float) (shensuo / 200.0);
        //这是得到计算没个圆柱体上方的空白区域
        mShenZhangYaTop = mViewHeight - shuzhangbii * mViewHeight;
        mShouSuoYaTop = mViewHeight - shensuobili * mViewHeight;
        //为每个圆柱体上方的int值赋值
        mShuZhangYaC1 = shuzhang;
        mShenSuoYaC1 = shensuo;

        invalidate();

    }


}

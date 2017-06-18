package jiyun.com.zidingyi_zhuzhuangtu;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int[] addssy = {150, 130, 180, 120, 180, 200};
    int[] addszy = {90, 110, 80, 50, 150, 100};
    private ZhuZhuangtuView mView;
    private int count;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (count < 6) {
                mView.setDate(addssy[count], addszy[count]);
                count++;
                Log.d("MainActivity", "count:" + count);
                handler.sendEmptyMessageDelayed(1,2000);
            } else {
                count = 0;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (ZhuZhuangtuView) findViewById(R.id.Zhu_id);
        handler.sendEmptyMessageDelayed(1,2000);
    }
}

package jiyun.com.zidingyi_zhuzhuangtu;

import android.app.Application;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/17 15:40
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(getApplicationContext());
    }
}

package jiyun.com.zidingyi_zhuzhuangtu.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import jiyun.com.zidingyi_zhuzhuangtu.R;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/17 19:12
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class Rxjava extends Activity {
    @Bind(R.id.But_Rxjava)
    Button ButRxjava;
    @Bind(R.id.But_Retrofit)
    Button ButRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.But_Rxjava, R.id.But_Retrofit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.But_Rxjava:
              new Observer<String>() {
                  @Override
                  public void onSubscribe(@NonNull Disposable d) {

                  }

                  @Override
                  public void onNext(@NonNull String s) {

                  }

                  @Override
                  public void onError(@NonNull Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              };

                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                    }
                });
                break;
            case R.id.But_Retrofit:
                break;
        }
    }
}

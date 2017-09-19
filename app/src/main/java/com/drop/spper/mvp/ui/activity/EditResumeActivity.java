package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerEditResumeComponent;
import com.drop.spper.di.module.EditResumeModule;
import com.drop.spper.mvp.contract.EditResumeContract;
import com.drop.spper.mvp.presenter.EditResumePresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zuo.biao.library.ui.DatePickerWindow;
import zuo.biao.library.util.Log;
import zuo.biao.library.util.TimeUtil;

import static com.jess.arms.utils.Preconditions.checkNotNull;
import static zuo.biao.library.util.CommonUtil.toActivity;


public class EditResumeActivity extends BaseActivity<EditResumePresenter> implements EditResumeContract.View {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my)
    TextView my;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.year)
    TextView year;
    @BindView(R.id.month)
    TextView month;
    @BindView(R.id.day)
    TextView day;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.school)
    EditText school;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.editText)
    EditText resume;
    @BindView(R.id.count)
    TextView count;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerEditResumeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .editResumeModule(new EditResumeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_edit_resume; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                if (requestCode == 1000) {
                    Long i = data.getLongExtra(DatePickerWindow.RESULT_TIME_IN_MILLIS, 0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(i);
                    String time = sdf.format(date);
                    String[] times = time.split("-");
                    year.setText(times[0]);
                    month.setText(times[1]);
                    day.setText(times[2]);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.toolbar_back, R.id.year, R.id.month, R.id.day, R.id.backll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.year:
            case R.id.month:
            case R.id.day:
                startActivityForResult(DatePickerWindow.createIntent(this, new int[]{1971, 0, 1}
                        , TimeUtil.getDateDetail(System.currentTimeMillis())), 1000);
                break;
            case R.id.backll:
                finish();
                break;
        }
    }
}

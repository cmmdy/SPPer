package com.drop.spper.mvp.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import io.reactivex.Observable;

import static com.drop.spper.R.id.photographer;

/**
 * Created by Drop on 2017/5/19.
 */

public class HolderThree extends BaseHolder<HotMovieBean.SubjectsBean> {

    @BindView(R.id.textView3)
    TextView date;
    @BindView(R.id.in_out)
    TextView inOut;
    @BindView(R.id.money_number)
    TextView moneyNumber;

    public HolderThree(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(HotMovieBean.SubjectsBean data, int position) {
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> date.setText("2017年5月19日"));
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> inOut.setText("收入"));
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> moneyNumber.setText("5.00"));
    }
}

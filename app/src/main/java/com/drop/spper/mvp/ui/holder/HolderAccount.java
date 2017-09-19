package com.drop.spper.mvp.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import io.reactivex.Observable;

import static android.media.CamcorderProfile.get;

/**
 * Created by Drop on 2017/5/20.
 */

public class HolderAccount extends BaseHolder<HotMovieBean.SubjectsBean> {

    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.money_number)
    TextView moneyNumber;
    @BindView(R.id.in_out)
    TextView inOut;

    public HolderAccount(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(HotMovieBean.SubjectsBean data, int position) {
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> name.setText(s));
        Observable.just(data.getYear())
                .subscribe(s -> date.setText(s+"年5月20日"));
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> moneyNumber.setText("5.00"));
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> inOut.setText("+"));
    }
}

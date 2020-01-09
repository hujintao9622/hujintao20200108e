package com.bawei.hujintao.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.hujintao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 7:51
 */
public class MyViewLayout extends LinearLayout {
    @BindView(R.id.myView_delete)
    TextView myViewDelete;
    @BindView(R.id.myView_num)
    TextView myViewNum;
    @BindView(R.id.myView_add)
    TextView myViewAdd;
    int num=1;
    public MyViewLayout(Context context) {
        super(context);
    }

    public MyViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.myview, this);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.myView_delete, R.id.myView_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myView_delete:
                if (num>1){
                    num--;
                    myViewNum.setText(""+num);
                    numChange.numChange(num);
                }
                break;
            case R.id.myView_add:
                num++;
                myViewNum.setText(""+num);
                numChange.numChange(num);
                break;
        }
    }

    public void setNum(int num) {
        this.num = num;
        myViewNum.setText(""+num);
    }
    NumChange numChange;

    public void setNumChange(NumChange numChange) {
        this.numChange = numChange;
    }

    public interface NumChange{
        void numChange(int num);
    }
}

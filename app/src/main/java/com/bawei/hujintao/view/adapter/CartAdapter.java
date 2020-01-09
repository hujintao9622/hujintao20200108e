package com.bawei.hujintao.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.model.bean.CartBean;
import com.bawei.hujintao.util.NetUtil;
import com.bawei.hujintao.widget.MyViewLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 6:28
 */
public class CartAdapter extends BaseExpandableListAdapter {

    private List<CartBean.ResultBean> list;

    public CartAdapter(List<CartBean.ResultBean> result) {
        list = result;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentHolder parentHolder;
        if (convertView == null) {
            //加载布局
            convertView = View.inflate(parent.getContext(), R.layout.item_parent, null);
            //创建优化类
            parentHolder = new ParentHolder(convertView);
            convertView.setTag(parentHolder);
        } else {
            //复用布局
            parentHolder = (ParentHolder) convertView.getTag();
        }
        //获取对应数据
        CartBean.ResultBean resultBean = list.get(groupPosition);
        parentHolder.parentName.setText(resultBean.getCategoryName());
        //判断商家是否全部选中
        boolean b = true;
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        for (int i = 0; i < shoppingCartList.size(); i++) {
            if (shoppingCartList.get(i).isChecked() == false) {
                b = false;
                break;
            }
        }
        //设置商家选中状态
        parentHolder.parentCh.setChecked(b);
        //点击事件
        boolean finalB = b;
        parentHolder.parentCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //商家状态
                boolean bool = finalB;
                //取反
                bool = !bool;
                //修改商品状态数据
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    shoppingCartList.get(i).setChecked(bool);
                    //刷新适配器
                    notifyDataSetChanged();
                    //通知外界
                    if (onCliceListener != null) {
                        onCliceListener.OnClick();
                    }
                }
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView == null) {
            //加载布局
            convertView = View.inflate(parent.getContext(), R.layout.item_child, null);
            //创建优化类
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        //获取对应数据
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        childHolder.childName.setText(shoppingCartListBean.getCommodityName());
        childHolder.childPrice.setText("￥" + shoppingCartListBean.getPrice());
        NetUtil.getInstance().getPhoto(shoppingCartListBean.getPic(), childHolder.childImg);
        //设置购物车商品数量
        childHolder.myView.setNum(shoppingCartListBean.getCount());
        //数量改变
        childHolder.myView.setNumChange(new MyViewLayout.NumChange() {
            @Override
            public void numChange(int num) {
                shoppingCartListBean.setCount(num);
                notifyDataSetChanged();
                if (onCliceListener != null) {
                    onCliceListener.OnClick();
                }

            }
        });
        childHolder.childCh.setChecked(shoppingCartListBean.isChecked());
        //点击事件
        childHolder.childCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击后取反值
                shoppingCartListBean.setChecked(!shoppingCartListBean.isChecked());
                //刷新适配器
                notifyDataSetChanged();
                //通知外界
                if (onCliceListener != null) {
                    onCliceListener.OnClick();
                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class ParentHolder {
        @BindView(R.id.parent_ch)
        CheckBox parentCh;
        @BindView(R.id.parent_name)
        TextView parentName;

        ParentHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildHolder {
        @BindView(R.id.child_ch)
        CheckBox childCh;
        @BindView(R.id.child_img)
        ImageView childImg;
        @BindView(R.id.child_name)
        TextView childName;
        @BindView(R.id.child_price)
        TextView childPrice;
        @BindView(R.id.myView)
        MyViewLayout myView;
        ChildHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    //计算总数
    public int getSumNumBer() {
        int sumNumber = 0;
        for (int i = 0; i < list.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isChecked()) {
                    sumNumber += shoppingCartListBean.getCount();
                }
            }
        }
        return sumNumber;
    }

    //计算总价格
    public float getSumPrice() {
        float sumPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isChecked()) {
                    sumPrice += shoppingCartListBean.getCount() * shoppingCartListBean.getPrice();
                }
            }
        }
        return sumPrice;
    }

    //获取全选状态
    public boolean getCheckIsChecked() {
        boolean b = true;
        for (int i = 0; i < list.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isChecked() == false) {
                    b = false;
                }
            }
        }
        return b;
    }

    //改变全选状态
    public void changeCheckIsChecked(boolean b) {
        for (int i = 0; i < list.size(); i++) {
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                shoppingCartListBean.setChecked(b);
                notifyDataSetChanged();
            }
        }
    }

    OnClickListener onCliceListener;

    public void setOnCliceListener(OnClickListener onCliceListener) {
        this.onCliceListener = onCliceListener;
    }

    public interface OnClickListener {
        void OnClick();
    }
}

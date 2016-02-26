package com.example.zhaoting.qiandao.module.tag;

import android.text.TextUtils;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.entity.novel.NovelInfo;
import com.example.zhaoting.qiandao.model.OnListener;
import com.example.zhaoting.qiandao.model.novel.NovelModel;
import com.example.zhaoting.qiandao.model.novel.NovelModelImpl;
import com.example.zhaoting.qiandao.utils.Utils;
import com.example.zhaoting.qiandao.widget.SmallTagImage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhaoting on 16/2/25.
 */
public class TagGridFragment extends BaseFragment implements OnListener {
    //    @Bind(R.id.id_small_tag_image)
    SmallTagImage mSmallTagImage;

    private NovelModel mNovelModel;

    @Override
    protected int getFragmentLayout() {
        return R.layout.bt_fragment_tag;
    }

    @Override
    protected void initViews() {
        mSmallTagImage = (SmallTagImage) mRootView.findViewById(R.id.id_small_tag_image);
    }

    @Override
    protected void initDatas() {
        mNovelModel = new NovelModelImpl();
        mNovelModel.getNovel(this, 10, 0, "banner", "", "", "");
    }

    @Override
    public void onSuccess(String s) {
        we(s);
        Utils.ToastShort("sagbvdsane");
    }

    private void we(String s) {
        try {
            JSONObject object = new JSONObject(s);
            JSONObject cursor = object.getJSONObject("cursor");
            int total = cursor.getInt("total");
            JSONArray array = object.getJSONArray("data");
            if (total == 0 || TextUtils.isEmpty(array.toString())) {

            } else {
                NovelInfo mNovelInfo = new NovelInfo(array.getJSONObject(0));
                mSmallTagImage.setData(mNovelInfo);
            }
            Utils.ToastShort("sagbvdsane");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Utils.ToastShort("sagbvdsane");
    }

    @Override
    public void onError() {
        Utils.ToastShort("error");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }
}

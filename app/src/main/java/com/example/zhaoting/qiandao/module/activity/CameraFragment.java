package com.example.zhaoting.qiandao.module.activity;

import android.view.View;
import android.widget.TextView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/7.
 */
public class CameraFragment extends BaseFragment {
    @Bind(R.id.barcode_scanner)
    CompoundBarcodeView mBarcodeScanner;
    @Bind(R.id.id_tv_name)
    TextView mIdTvName;
    @Bind(R.id.id_tv_sign)
    TextView mIdTvSign;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if (result.getText() != null) {
                mBarcodeScanner.setStatusText("读取成功");
                mIdTvName.setText(result.getText());
            }
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };


    @Override
    public void onPause() {
        super.onPause();
        mBarcodeScanner.pause();
    }


    @Override
    public void onResume() {
        super.onResume();
        mBarcodeScanner.resume();
    }

    public void triggerScan(View view) {
        mBarcodeScanner.decodeSingle(callback);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_camera;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        mBarcodeScanner.decodeContinuous(callback);
    }


}

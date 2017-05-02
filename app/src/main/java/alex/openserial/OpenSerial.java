package alex.openserial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpenSerial extends Activity {

    @BindView(R.id.sample_text)
    TextView mSampleText;
    @BindView(R.id.myswitchser)
    SwitchButton mMyswitchser;
/*    @BindView(R.id.myswitch)
    FunSwitch mMyswitch;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_serial);
        ButterKnife.bind(this);
      //  Log.e("pangsheng", " true " + Ctrset(true) + "  false " + Ctrset(false));


        mMyswitchser.setOnChangeListener(new SwitchButton.OnChangeListener() {
            @Override
            public void onChange(SwitchButton sb, boolean state) {
                if (!state) {
                    if (Ctrset(true) == 1) {
                        Toast.makeText(getApplicationContext(), "打开成功", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "打开失败", Toast.LENGTH_SHORT).show();
                } else {
                    if (Ctrset(false) == 1) {
                        // mSampleText.setText(String.valueOf(Ctrset(true)));
                        Toast.makeText(getApplicationContext(), "关闭成功", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "关闭失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public native int Ctrset(boolean ison);

    static {
        System.loadLibrary("mytest-lib");
    }



}

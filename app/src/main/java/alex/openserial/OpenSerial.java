package alex.openserial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class OpenSerial extends Activity {

    @BindView(R.id.sample_text)
    TextView mSampleText;
    @BindView(R.id.switch1)
    Switch mSwitch1;
    @BindView(R.id.myswitchser)
    SwitchButton mMyswitchser;
/*    @BindView(R.id.myswitch)
    FunSwitch mMyswitch;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_serial);
        ButterKnife.bind(this);
        Log.e("pangsheng", " true " + Ctrset(true) + "  false " + Ctrset(false));


        mMyswitchser.setOnChangeListener(new SwitchButton.OnChangeListener() {
            @Override
            public void onChange(SwitchButton sb, boolean state) {
                if (!state) {
                    if (Ctrset(true) == 1) {
                        Toast.makeText(getApplicationContext(), "我就是一", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "我就是零", Toast.LENGTH_SHORT).show();
                } else {
                    if (Ctrset(false) == 1) {
                        // mSampleText.setText(String.valueOf(Ctrset(true)));
                        Toast.makeText(getApplicationContext(), "我就是一", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "我就是零", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public native int Ctrset(boolean ison);

    static {
        System.loadLibrary("mytest-lib");
    }



    @OnCheckedChanged(R.id.switch1)
    public void isoccc() {
        if (mSwitch1.isChecked()) {

            mSampleText.setText(String.valueOf(Ctrset(true)));
            Log.e("pangsheng", " true ");
        } else {


            mSampleText.setText(String.valueOf(Ctrset(false)));
            Log.e("pangsheng", " false ");
        }

    }



/*    @OnCheckedChanged(R.id.myswitch)
    public void onViewClicked() {
        if (mSwitch1.isChecked()) {

            mSampleText.setText(String.valueOf(Ctrset(true)));
            Log.e("pangsheng", "my true ");
        } else {

            mSampleText.setText(String.valueOf(Ctrset(false)));
            Log.e("pangsheng", "my false ");
        }

    }*/
}

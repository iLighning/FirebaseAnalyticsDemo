package ilightning.firebaseanalytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAnalytics mFirebaseAnalytics;

    @BindView(R.id.btnClickParam)
    Button btnClickParam;
    @BindView(R.id.btnClickEvent)
    Button btnClickEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HoangTV", "onCreate()");

        // Obtain the FireBase Analytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ButterKnife.bind(this);

        // Set event on click listener for Button.
        btnClickParam.setOnClickListener(this);
        btnClickEvent.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HoangTV", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HoangTV", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HoangTV", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HoangTV", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HoangTV", "onDestroy()");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClickParam:
                Log.d("HoangTV", "btnClickParam");
                Bundle params = new Bundle();
                params.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
                params.putString(FirebaseAnalytics.Param.ITEM_NAME, "HoangTV");
                params.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params);
                break;
            case R.id.btnClickEvent:
                Log.d("HoangTV", "btnClickEvent");
                // [START image_view_event]
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "HoangTV");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                // [END image_view_event]
                break;
            default:
                break;
        }
    }
}

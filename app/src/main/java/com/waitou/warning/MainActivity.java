package com.waitou.warning;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.waitou.warning_lib.Warning;
import com.waitou.warning_lib.WarningUtils;

public class MainActivity extends AppCompatActivity {

    String url = "https://github.com/zguop/Waitou_Json/blob/master/warning/warning_wfsh.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Warning warning = new Warning(
                        "https://github.com/zguop/Waitou_Json/",
                        "blob/master/warning/warning_wfsh.json"
                );

                WarningUtils.waringPerform(warning);

            }
        });
    }
}

package com.klh.bussin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RouteSelectionActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_view);
    }

    private void initViews(){
        findViewById(R.id.route1).setOnClickListener(this);
        findViewById(R.id.route2).setOnClickListener(this);
        findViewById(R.id.route3).setOnClickListener(this);
        findViewById(R.id.route4).setOnClickListener(this);
        findViewById(R.id.route5).setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
         return  super.onCreateView(parent, name, context, attrs);

    }

    @Override
    public void onClick(View v) {
        String route ="route1";
        switch (v.getId()){
            case R.id.route1:
                route = "route1";
                break;
            case R.id.route2:
                route = "route2";
                break;
            case R.id.route3:
                route = "route3";
                break;
            case R.id.route4:
                route = "route4";
                break;
            case R.id.route5:
                route = "route5";
                break;
        }
        Intent i = new Intent(RouteSelectionActivity.this, MainActivity.class);
        i.putExtra("ROUTE",route);
        startActivity(i);

    }
}

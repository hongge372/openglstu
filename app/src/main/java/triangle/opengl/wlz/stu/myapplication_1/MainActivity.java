package triangle.opengl.wlz.stu.myapplication_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import triangle.opengl.wlz.stu.myapplication_1.gl.CostomView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getName();

    private int size = 1;
    Button[] button = new Button[size];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        layout_set();
    }

    private void layout_set(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                switch (v.getId()){
                    case R.id.costom_glview:
                        intent.setClass(getApplicationContext(), CostomView.class);
                        break;
                }
                startActivity(intent);
            }
        };

        button[0] = (Button)findViewById(R.id.costom_glview);
        for(int i=0;i<size;i++){
            button[i].setOnClickListener(listener);
        }
    }
}

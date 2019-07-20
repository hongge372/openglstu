package triangle.opengl.wlz.stu.myapplication_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import triangle.opengl.wlz.stu.myapplication_1.costomview.CostomView;
import triangle.opengl.wlz.stu.myapplication_1.gles.BackgroundRed;
import triangle.opengl.wlz.stu.myapplication_1.gles.DrawPoint;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getName();

    private int size = 3;
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
                    case R.id.bt_costom_glview:
                        intent.setClass(getApplicationContext(), CostomView.class);
                        break;
                    case R.id.bt_gl_background:
                        intent.setClass(getApplicationContext(), BackgroundRed.class);
                    case R.id.bt_draw_point:
                        intent.setClass(getApplicationContext(), DrawPoint.class);
                }
                startActivity(intent);
            }
        };

        button[0] = (Button)findViewById(R.id.bt_costom_glview);
        button[1] = (Button)findViewById(R.id.bt_gl_background);
        button[2] = (Button)findViewById(R.id.bt_draw_point);
        for(int i=0;i<size;i++){
            button[i].setOnClickListener(listener);
        }
    }
}

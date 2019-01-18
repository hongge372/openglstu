package triangle.opengl.wlz.stu.myapplication_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import triangle.opengl.wlz.stu.myapplication_1.gl.DGLView;

public class MainActivity extends AppCompatActivity {
    triangle.opengl.wlz.stu.myapplication_1.gl.DGLView view;
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package triangle.opengl.wlz.stu.myapplication_1.gles;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class BackgroundRed extends AppCompatActivity {
    private GLSurfaceView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vewInit();
    }

    private void vewInit() {
        view = new GLSurfaceView(this);
        setContentView(view);
        view.setRenderer(new BGGLRunderer());
    }


    public void BGDrawScence(GL10 gl){
        gl.glClearColor(1f, 0f, 0f, 0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }

    private class BGGLRunderer extends GLRunderer{

        @Override
        public void DrawScence(GL10 gl) {
            BGDrawScence(gl);
        }
    }
}

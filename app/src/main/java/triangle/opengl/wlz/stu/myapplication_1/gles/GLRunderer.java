package triangle.opengl.wlz.stu.myapplication_1.gles;


import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class GLRunderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //alpha?
        gl.glClearColor(0f, 0f, 0f, 0.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearDepthf(1f);
        gl.glEnable(GL10.GL_DEPTH_BITS);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float)width/(float)height, 0.1f, 100f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        //3d?
        GLU.gluPerspective(gl, 45f, (float)width/(float)height, 0.1f, 100f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        DrawScence(gl);

    }

    public abstract void DrawScence(GL10 gl);
}

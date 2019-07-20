package triangle.opengl.wlz.stu.myapplication_1.costomview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.support.constraint.Constraints.TAG;


public class DGLView extends GLSurfaceView implements GLSurfaceView.Renderer{
    private DGLRender dglRender;

    public DGLView(Context context) {
        super(context);
        Log.d(TAG, "DGLView Context context");
        init();
    }

    public DGLView(Context context, AttributeSet attrs){
        super(context, attrs);
        Log.d(TAG, "DGLView Context context, AttributeSet attrs");
        init();
    }

    private void init(){
        dglRender = new DGLRender();
        setEGLContextClientVersion(2);
        setRenderer(this);
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d(TAG, "onSurfaceCreated");
        dglRender.onSurfaceCreated(gl, config);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.d(TAG, "onSurfaceChanged");
        dglRender.onSurfaceChanged(gl, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Log.d(TAG, "onDrawFrame");
        dglRender.onDrawFrame(gl);
    }
}

package triangle.opengl.wlz.stu.myapplication_1.gl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class DGLRender implements GLSurfaceView.Renderer {
    private final String vertex = "" +
            "attribute vec4 vPosition;" +
            "void main(){" +
            "gl_Position=vPosition;" +
            "}";
    private final String fragment = "" +
            "precision mediump float;" +
            "uniform vec4 vColor;" +
            "void main(){" +
            "gl_FragColor=vColor;" +
            "}";
    private final float[] pos = {
            -0.5f, -0.5f, 0f,
             0.5f,  0.5f, 0f,
             0.5f, -0.5f, 0f,
    };
    private final float[] colors = {
            0f, 0f, 1.0f, 1.0f,
    };

    int program;
    FloatBuffer vertexBuffer;
    private float[] mRotationMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1f);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(pos.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(pos);
        vertexBuffer.position(0);
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertex);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragment);
        program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
    }

    private int loadShader(int type, String source){
        int shader = 0;
        shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        return shader;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        drawStatic(gl);
    }

    public void drawAnimator(GL10 gl){}

    public void drawStatic(GL10 gl){
        //?如果没有
        GLES20.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        GLES20.glUseProgram(program);
        int vPositionHandler = GLES20.glGetAttribLocation(program, "vPosition");
        GLES20.glEnableVertexAttribArray(vPositionHandler);
        GLES20.glVertexAttribPointer(vPositionHandler, 3, GLES20.GL_FLOAT, false, 12, vertexBuffer);
        int vColor = GLES20.glGetUniformLocation(program, "vColor");
        GLES20.glUniform4fv(vColor, 1 , colors, 0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 3);
        GLES20.glDisableVertexAttribArray(vPositionHandler);
    }
}

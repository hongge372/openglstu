package triangle.opengl.wlz.stu.myapplication_1.gles;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Pholyhedron extends BackgroundRed {
    int angle = 0;
    static final float X = .52f;
    static final float Z = .85f;
    static float vertices[] = new float[]{
      -X,0f,Z,   X,0f,Z,    -X,0f,-Z,   X,0f,-Z,
      0f,Z,X,    0f,Z,-X,   0f,-Z,X,    0f,-Z,-X,
      Z,X,0f,    -Z,X,0f,   Z,-X,0f,    -Z,-X,0f,
    };

    static short indices[] = new short[]{
            0, 4,1,   0,9,4,   9,5,4,   4,5,8,   4,8,1,
            8,10,1,   8,3,10,  5,3,8,   5,2,3,   2,7,3,
            7,10,3,   7,6,10,  7,11,6,  11,0,6,  0,1,6,
            6,1,10,   9,0,11,  9,11,2,  9,2,5,   7,2,11,
    };

    float[] colors = {
            0.0f, 0.1f, 0.0f, 1f,
            0.2f, 0.0f, 0.2f, 1f,
            0.0f, 0.1f, 0.0f, 1f,
            0.0f, 0.0f, 0.0f, 1f,
            1.0f, 0.2f, 0.0f, 1f,
            0.5f, 0.2f, 0.2f, 1f,
            0.0f, 0.0f, 0.8f, 1f,
            0.0f, 0.3f, 0.9f, 1f,
            0.7f, 0.3f, 0.5f, 1f,
            0.6f, 0.6f, 0.6f, 1f,
            0.8f, 0.8f, 0.8f, 1f,
            0.9f, 0.9f, 0.9f, 1f,
    };
    private FloatBuffer vertexBuffer;
    private FloatBuffer colorbuffer;
    private ShortBuffer indexBuffer;


    @Override
    public void BGDrawScence(GL10 gl) {
        super.BGDrawScence(gl);
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());
        colorbuffer = cbb.asFloatBuffer();
        colorbuffer.put(colors);
        colorbuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length*2);
        ibb.order(ByteOrder.nativeOrder());
        indexBuffer = ibb.asShortBuffer();
        indexBuffer.put(indices);
        indexBuffer.position(0);

        gl.glColor4f(0.5f, 0.6f, 0.6f, 1f);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        gl.glRotatef(angle, 0, 1, 0);
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorbuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
        angle++;
    }
}
package triangle.opengl.wlz.stu.myapplication_1.gles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawPoint extends BackgroundRed {
    float[] vertexArray = new float[]{
      -0.8f, -0.4f*1.732f, 0f,
      0.8f, -0.4f*1.732f, 0f,
      0f, 0.4f*1.732f, 0f,
    };

    @Override
    public void BGDrawScence(GL10 gl) {
        super.BGDrawScence(gl);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length*4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

        gl.glColor4f(0f, 1f, 1f, 1f);
        //这里demo是8，改成128后，点变成一个大方块。
        gl.glPointSize(128f);

        //刷新上一帧的变换矩阵。
        gl.glLoadIdentity();
        //设置相机位置, ?这里设置的是相机还是物体？
        gl.glTranslatef(0, 0, -4f);

        //新的写法，会发现一个有趣的动画：
        //注释掉矩阵还原函数
        //gl.glLoadIdentity();
        //这里持续缓慢移动
        //gl.glTranslatef(0, 0, -0.1f);


        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        gl.glDrawArrays(GL10.GL_POINTS, 0, 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}

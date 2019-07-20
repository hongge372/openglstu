package triangle.opengl.wlz.stu.myapplication_1.gles;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class LineSegment extends BackgroundRed {
    int index = 0;

    float vertexArray[] = {
            -0.8f, -0.4f*1.732f, 0f,
            -0.4f, 0.4f*1.732f, 0f,
            0f, -0.4f*1.732f, 0f,
            0.4f, 0.4f*1.732f, 0f,
    };

    @Override
    public void BGDrawScence(GL10 gl){
        super.BGDrawScence(gl);
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length*4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        index++;
        //demo的算法太快了。
        //index%=10;
        //这里改下算法，把刷新频率降到到十分之一。
        int tmp = index / 10;
        tmp%=10;
        switch (tmp){
            case 0:
            case 1:
            case 2:
                gl.glColor4f(0f, 1f, 1f, 1f);
                gl.glDrawArrays(GL10.GL_LINES, 0, 4);
                break;
            case 3:
            case 4:
            case 5:
                gl.glColor4f(0f, 1f, 0f, 1f);
                gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 4);
                break;
            case 7:
            case 8:
            case 9:
                gl.glColor4f(0f, 0f, 1f, 1f);
                gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
                break;
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

}

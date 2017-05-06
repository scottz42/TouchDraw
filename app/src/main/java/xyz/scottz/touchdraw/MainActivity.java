package xyz.scottz.touchdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    int x , y ;
    boolean right ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CustomView v = new CustomView(this);

        super.onCreate(savedInstanceState);
        setContentView(v);
        v.setOnTouchListener(this);
        right=true;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(null, "OnTouchListener--onTouch-- action="+event.getAction()+" --"+v);

  //      x = (int)event.getX();
  //      y = (int)event.getY();
if (right) {
    x += 50;
} else {
    x-=50;
}

        if (x>800) {
        right=false;
        }
        if(x<0){
            right=true;
        }

        v.invalidate();
        return false;
    }

    class CustomView extends View{

        Paint p;

        public CustomView (Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.BLUE);
            p.setStrokeWidth(20);
            p.setStyle(Paint.Style.STROKE);
            x =100; y = 600 ;
        }

        @Override
        protected void onDraw(Canvas canvas) {
              int arm = 100 ;
            int leg = 200;
int head=100;
             int leftLegX = x-63-arm/2;
            int leftLegY = y+63+arm/2;
            int rightLegX = x+63+arm/2;
            int rightLegY = y+63+arm/2;

            canvas.drawCircle(x,y-90-head,head,p);
            canvas.drawCircle(x,y,90,p);
            canvas.drawLine(x-63,y+63,x-63-arm,y+63+arm,p);
            canvas.drawLine(x+63,y+63,x+63+arm,y+63+arm,p);
            canvas.drawLine(leftLegX,leftLegY,leftLegX,leftLegY+leg,p);
            canvas.drawLine(rightLegX,rightLegY,rightLegX,rightLegY+leg,p);

//            x += 100 ;
//            y += 100 ;
            Log.d("x=",Integer.toString(x));
        }
    }
}


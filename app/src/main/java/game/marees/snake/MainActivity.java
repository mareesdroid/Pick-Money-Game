package game.marees.snake;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    int a;
    int b;
    int snakes =10;
    int playerLevel=1;
    int stage =1;
    ImageView image,moneyMan;
    boolean setAll = true;
    ImageView kasu;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot);


       layout = findViewById(R.id.imageLayout);
       kasu = findViewById(R.id.kasu);
        ViewTreeObserver observer = layout.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                init();
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
               resetGame();

            }
        });




    }

    private void plotSnakes() {

        stage++;
        for(int i=0;i<snakes;i++)
        {

            int left = randomWithRange(b);
            int right =randomWithRange(b);
            int top = randomWithRange(a);
            int down=randomWithRange(a);

            ImageView image = new ImageView(MainActivity.this);
            image.setLayoutParams(new LinearLayout.LayoutParams(80,60));
            setMargins(image, left, top, right, down);
            ///image.setMaxWidth(20);
            image.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.snake));

            Log.e("",randomWithRange(b)+"");
            Log.e("",randomWithRange(a)+"");


            // Adds the view to the layout
            layout.addView(image);

            image.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    sryloseStartFrmScratch();
                }
            });

        }



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void sryloseStartFrmScratch() {
        playerLevel = 1;
        snakes = 10;
        stage = 1;
        resetGame();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void resetGame() {

        if(((RelativeLayout) layout).getChildCount() > 0) {
            ((RelativeLayout) layout).removeAllViews();
        }

            setAll=false;
            plotObjects();
            plotSnakes();
            plotMoney();



        if(stage % 5 == 0){



             }
        }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void plotObjects() {
        for (int i = 0; i < 2; i++) {

            int left = randomWithRange(b);
            int right = randomWithRange(b);
            int top = randomWithRange(a);
            int down = randomWithRange(a);

            ImageView image = new ImageView(MainActivity.this);
            image.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
            setMargins(image, left, top, right, down);
            ///image.setMaxWidth(20);
            image.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.obj4));

            layout.addView(image);

        }
        for (int i = 0; i < 2; i++) {

            int left = randomWithRange(b);
            int right = randomWithRange(b);
            int top = randomWithRange(a);
            int down = randomWithRange(a);

            ImageView image = new ImageView(MainActivity.this);
            image.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
            setMargins(image, left, top, right, down);
            ///image.setMaxWidth(20);
            image.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.obj3));

            layout.addView(image);

        }
        for (int i = 0; i < 3; i++) {

            int left = randomWithRange(b);
            int right = randomWithRange(b);
            int top = randomWithRange(a);
            int down = randomWithRange(a);

            ImageView image = new ImageView(MainActivity.this);
            image.setLayoutParams(new RelativeLayout.LayoutParams(400, 400));
            setMargins(image, left, top, right, down);
            ///image.setMaxWidth(20);
            image.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.obj2));

            layout.addView(image);

        }
        for (int i = 0; i < 4; i++) {

            int left = randomWithRange(b);
            int right = randomWithRange(b);
            int top = randomWithRange(a);
            int down = randomWithRange(a);

            ImageView image = new ImageView(MainActivity.this);
            image.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
            setMargins(image, left, top, right, down);
            ///image.setMaxWidth(20);
            image.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.obj1));

            layout.addView(image);

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void plotMoney() {

        int left;
        int right;

        int top;
        int down;
        int maxwid=b-80;
        int maxheight=a-80;


            do{
                left = randomWithRange(b);
                right =randomWithRange(b);

            }while (left>maxwid || right>maxwid);

        do{
            top = randomWithRange(a);
            down=randomWithRange(a);

        }while (top>maxheight || down>maxheight);



        ImageView kasu = new ImageView(MainActivity.this);
        kasu.setLayoutParams(new RelativeLayout.LayoutParams(50, 50));
        setMargins(kasu, left, top, right, down);
        ///image.setMaxWidth(20);
        kasu.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.money));

        layout.addView(kasu);

        kasu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youWinMarsStartAgain();
                }
            });
        }

    private void setDimensions(View view, int width, int height){
        android.view.ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void youWinMarsStartAgain() {

        playerLevel++;
        snakes++;
        resetGame();


    }

    public void init() {
       a= layout.getHeight()-70;
       b = layout.getWidth()-70;
        Toast.makeText(getApplicationContext(),""+a+" "+b,Toast.LENGTH_LONG).show();
    }

    private int randomWithRange(int max)
    {
        int min = 0;
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
//    public static int getScreenWidth() {
//        return Resources.getSystem().getDisplayMetrics().widthPixels;
//    }
//
//    public static int getScreenHeight() {
//        return Resources.getSystem().getDisplayMetrics().heightPixels;
//    }


    @Override
    public void onBackPressed() {
        dialog alert = new dialog();
        alert.showDialog(MainActivity.this);
    }



class dialog {

        MainActivity m = new MainActivity();
        public void showDialog(Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            FrameLayout mDialogNo = dialog.findViewById(R.id.frmNo);
            mDialogNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(dialog.this,"Cancel" ,Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

            FrameLayout mDialogOk = dialog.findViewById(R.id.frmOk);
            mDialogOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();

                    dialog.cancel();
                    finish();

                }
            });

            dialog.show();
        }
    }



}

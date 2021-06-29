package srikanth.different.withnewandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MyServiceConecction connection;
    IMyAidlInterface mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int id = android.os.Process.myPid();
        System.out.println("#6010944 onCreate "+id);

        connection = new MyServiceConecction();
        initService();

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Vehicle vehi= mService.getVehicle();
                    String deepObj = vehi.c.whatIsbase;
                    Toast.makeText(getApplicationContext(), deepObj, Toast.LENGTH_LONG).show();

                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Vehicle veh = mService.getVehicle();
                    String comapny = veh.catageory;
                    String mode = veh.c.name;
                    String Company = veh.group.company1;
                   Toast.makeText(getApplicationContext(), comapny+"=="+mode+"=="+Company, Toast.LENGTH_LONG).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Vehicle vc2 = mService.getVehicle();
                    Car newCar = vc2.createCar("Creta", 2021);
      Toast.makeText(getApplicationContext(), newCar.name+"=="+newCar.model, Toast.LENGTH_LONG).show();

                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    class MyServiceConecction implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
                 System.out.println("#6010944 Service Connected");
                 mService = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }


    private void initService() {
        Intent i = new Intent();
        i.setClassName(this.getPackageName(), MyService.class.getName());
        boolean bindResult = bindService(i, connection, Context.BIND_AUTO_CREATE);
        Log.i("6010944", "initService() bindResult: " + bindResult);

        /*if(bindResult) {
            buttonSerial.setClickable(true);
            buttonVersionCode.setClickable(true);
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
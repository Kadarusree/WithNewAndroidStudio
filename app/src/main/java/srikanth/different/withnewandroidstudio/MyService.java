package srikanth.different.withnewandroidstudio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        int id = android.os.Process.myPid();


        System.out.println("#6010944 Service Started  == "+id);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        System.out.println("#6010944 Service On Bind");
        return new IMyAidlInterface.Stub() {
            @Override
            public String getSerialNumber() throws RemoteException {
                return null;
            }

            @Override
            public int getVersionCodes() throws RemoteException {
                return 0;
            }

            @Override
            public Vehicle getVehicle() throws RemoteException {
                Vehicle v = new Vehicle();
                v.createCar("Sreekanth",6010944);
                return v;
            }
        };
      //  throw new UnsupportedOperationException("Not yet implemented");
    }


}
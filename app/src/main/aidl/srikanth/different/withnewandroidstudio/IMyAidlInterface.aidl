// IMyAidlInterface.aidl
package srikanth.different.withnewandroidstudio;

// Declare any non-default types here with import statements
import srikanth.different.withnewandroidstudio.Vehicle;
interface IMyAidlInterface {

   String getSerialNumber();
      int getVersionCodes();
      Vehicle getVehicle();
}
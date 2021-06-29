package srikanth.different.withnewandroidstudio;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {
    String catageory = "Motor";
    ManuFactureRes group;
    Car c;
    public Vehicle(){
             group = new ManuFactureRes();
             c = new Car("Super",29);
    }
    protected Vehicle(Parcel in) {
        catageory = in.readString();
        c = in.readParcelable(Car.class.getClassLoader());
        group = (ManuFactureRes) in.readSerializable();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(catageory);
        dest.writeParcelable(c,1);
        dest.writeSerializable(group);
    }

    public  Car createCar(String name, int model){
        c = new Car(name, model);
        return  c;
    }
}

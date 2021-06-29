package srikanth.different.withnewandroidstudio;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Car extends BaseCar implements CarSpecs,Parcelable {

    String name = "Hyundai";
    int model = 200;


    public Car(String name, int model) {
        this.name = name;
        this.model = model;

        int id = android.os.Process.myPid();

        System.out.println("#6010944 Const1  "+id);

    }


    protected Car(Parcel in) {
        name = in.readString();
        model = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(model);
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public void setSteeringSide(int side) {

    }

    @Override
    public void setModel(int model) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void testAbsMethod() {
        whatIsbase = "Modified What is base variable";
    }


}

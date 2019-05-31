package comp.example.hreday.restapiretrofit;


import com.google.gson.annotations.SerializedName;

public class PojoClass {


    String name;
    String image;

    String hobby;


    public PojoClass() {
    }


    public PojoClass(String name, String image, String hobby) {
        this.name = name;
        this.image = image;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}



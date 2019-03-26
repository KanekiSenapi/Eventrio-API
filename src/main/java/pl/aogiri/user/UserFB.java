package pl.aogiri.user;

public class UserFB {
    String id;
    String name;
    String email;
    Picture picture;

    public UserFB() {
    }

    public UserFB(String id, String name, String email, Picture picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}

class Picture{
    Data data;

    public Picture() {
    }

    public Picture(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

class Data{
    int height;
    int width;
    boolean is_silhoutte;
    String url;

    public Data() {
    }

    public Data(int height, int width, boolean is_silhoutte, String url) {
        this.height = height;
        this.width = width;
        this.is_silhoutte = is_silhoutte;
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIs_silhoutte() {
        return is_silhoutte;
    }

    public void setIs_silhoutte(boolean is_silhoutte) {
        this.is_silhoutte = is_silhoutte;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}




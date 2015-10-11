package ca.umeshkhanna.gitme;

/**
 * Created by umeshkhanna on 15-10-11.
 */


public class User {
    private String name;
    private String email;
    private String avatar_url;
    private String location;
    private int followers;
    private int following;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getLocation() {
        return location;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
}



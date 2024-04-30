package com.example.tugas5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String fullname, username, caption;
    private Integer profile, post;
    private Uri addpost;

    public User(String fullname, String username, String caption, Integer profile, Integer post) {
        this.fullname = fullname;
        this.username = username;
        this.caption = caption;
        this.profile = profile;
        this.post = post;
    }

    public User(String fullname, String username, String caption, Integer profile, Uri addpost) {
        this.fullname = fullname;
        this.username = username;
        this.caption = caption;
        this.profile = profile;
        this.addpost = addpost;
    }

    protected User(Parcel in) {
        fullname = in.readString();
        username = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        addpost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Uri getAddpost() {
        return addpost;
    }

    public void setAddpost(Uri addpost) {
        this.addpost = addpost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(fullname);
        dest.writeString(username);
        dest.writeString(caption);
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        dest.writeParcelable(addpost, flags);
    }
}


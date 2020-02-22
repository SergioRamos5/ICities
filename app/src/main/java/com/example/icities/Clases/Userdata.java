package com.example.icities.Clases;

import android.os.AsyncTask;

import com.example.icities.JsonResponse;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;

@Xml(name = "userdata")
public class Userdata extends UserDataFromRest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @PropertyElement(name = "uid")
    private String uid;
    @PropertyElement(name = "username")
    private String username;
    @PropertyElement(name = "usersurname")
    private String usersurname;
    @PropertyElement(name = "userphone")
    private String userphone;

    public Userdata()
    {
    }

    public Userdata(String uid)
    {
        this.uid = uid;
    }

    public Userdata(String uid, String username, String usersurname, String userphone)
    {
        this.uid = uid;
        this.username = username;
        this.usersurname = usersurname;
        this.userphone = userphone;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsersurname()
    {
        return usersurname;
    }

    public void setUsersurname(String usersurname)
    {
        this.usersurname = usersurname;
    }

    public String getUserphone()
    {
        return userphone;
    }

    public void setUserphone(String userphone)
    {
        this.userphone = userphone;
    }

    public boolean updateDB()
    {
        Call<JsonResponse> jsonResponseCall = createRetrofit().editUser(this);
        AsyncTask updateUserAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    jsonResponseCall.execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean updateUserResponse = false;
        try {
            updateUserAsyncTask.execute();
            updateUserResponse = (boolean) updateUserAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return updateUserResponse;
    }

    public boolean deleteFromDB(){
        Call<JsonResponse> jsonResponseCall = createRetrofit().deleteUser(this.uid);
        AsyncTask deleteUserAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    jsonResponseCall.execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean deleteUserResponse = false;
        try {
            deleteUserAsyncTask.execute();
            deleteUserResponse = (boolean) deleteUserAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return deleteUserResponse;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdata))
            return false;
        Userdata other = (Userdata) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "clases.Userdata[ uid=" + uid + " ]";
    }

}

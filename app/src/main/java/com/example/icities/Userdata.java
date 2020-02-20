package com.example.icities;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;

@Xml(name = "userdata")
public class Userdata implements Serializable
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

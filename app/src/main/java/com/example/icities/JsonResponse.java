package com.example.icities;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "response")
public class JsonResponse {
    @PropertyElement(name = "status")
    public int respuesta;
    @PropertyElement(name = "metodo")
    public String metodo;
    @PropertyElement(name = "tabla")
    public String tabla;
    @PropertyElement(name = "sqlQuery")
    public String sqlQuery;
    @PropertyElement(name = "mensaje")
    public String mensaje;
    @PropertyElement(name = "sqlError")
    public String sqlError;

    public JsonResponse(int respuesta, String metodo, String tabla, String sqlQuery, String mensaje, String sqlError) {
        this.respuesta = respuesta;
        this.metodo = metodo;
        this.tabla = tabla;
        this.sqlQuery = sqlQuery;
        this.mensaje = mensaje;
        this.sqlError = sqlError;
    }

    public JsonResponse() {
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getSqlError() {
        return sqlError;
    }

    public void setSqlError(String sqlError) {
        this.sqlError = sqlError;
    }
}
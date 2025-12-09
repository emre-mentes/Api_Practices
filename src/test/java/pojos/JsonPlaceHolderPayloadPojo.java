package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Olusturdugumuz pojo objecti ile response tan gelen data tam olarak uyumlu degilse,
yani response datasinda fazladan baska field lar var ise, bu alanlari görmezden gelebilmek icin
hata almamak icin pojo clasimizin basina
@JsonIgnoreProperties(ignoreUnknown = true)
kodunu eklemeliyiz
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPayloadPojo {

    /*
    Icinde
        1) private variable lar
        2) Parametreli ve parametresiz constructorlar
        3) getterlar ve setterlar
        4) toString() methodu barindiran classlara POJO class denir

        POJO ==> Plain Old Java Object

        Amacimiz ==> Belirli bir cerceveye yada kısıtlamaya bagli kalmadan
        basit, bagimsiz ve Reusable json formatina uygun datalarimizi tasiyici objectler olusturmaktir

     */

    //  1) private variable lar
    private Integer userId;
    private String title;
    private Boolean completed;

    //  2) Parametreli ve parametresiz constructorlar
    public JsonPlaceHolderPayloadPojo() {
        //jackson databind
        //serialization ve deserialization islemlerini gerceklestirirken
        //bu constructor a arka planda ihtiyac duyar
    }

    public JsonPlaceHolderPayloadPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //3) getterlar ve setterlar
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) toString()
    @Override
    public String toString() {
        return "JsonPlaceHolderPayloadPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
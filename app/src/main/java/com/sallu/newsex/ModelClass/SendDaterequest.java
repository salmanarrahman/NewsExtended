package com.sallu.newsex.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendDaterequest {

   @SerializedName("dateID")
   private int dateID ;

   public SendDaterequest(int dateid){
      this.dateID = dateid;
   }
   public SendDaterequest(){

   }

   public int getdate(){
      return dateID;
   }

   public void setDate(int dateid){
      this.dateID = dateid;
   }



}

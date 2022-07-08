package com.example.a652

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.Gravity
import android.widget.Toast

class CallReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)
           == TelephonyManager.EXTRA_STATE_OFFHOOK
       ){
           showToastMsg(context!!, "Phone Call is Started")
       }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE)
           == TelephonyManager.EXTRA_STATE_IDLE
       ){
          showToastMsg(context!!, "Phone call is Ended...")
       }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE)
           == TelephonyManager.EXTRA_STATE_RINGING
       ){
           showToastMsg(context!!, "Incoming Calls ...")
       }
    }
    fun showToastMsg(c:Context, msg:String){
        val toast = Toast.makeText(c,msg,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }
}
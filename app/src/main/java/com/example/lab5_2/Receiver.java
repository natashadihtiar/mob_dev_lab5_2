package com.example.lab5_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;
//Получатель сообщений
public class Receiver extends BroadcastReceiver {

    @Override
    //Получение сообщения
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                //Формат полученного сообщения
                String msg = "От " + smsMessage.getOriginatingAddress() + " : " + smsMessage.getMessageBody();
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}

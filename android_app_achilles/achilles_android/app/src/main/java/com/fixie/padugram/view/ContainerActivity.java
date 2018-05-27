package com.fixie.padugram.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fixie.padugram.R;
import com.fixie.padugram.view.fragment.HomeFragment;
import com.fixie.padugram.view.fragment.ProfileFragment;
import com.fixie.padugram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import android.content.Context;
import android.text.LoginFilter;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOError;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Handler;

public class ContainerActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    private int counter = 0;

    TextView t1;

    WebView webView;

    String address = null , name=null;

    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    Set<BluetoothDevice> pairedDevices;

    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        webView = (WebView) findViewById(R.id.webViewContainer);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://achillesapp-205313.appspot.com");

        t1 = (TextView) findViewById(R.id.bluetoothConnection);
    }

    public void setw() throws IOException{
        bluetooth_connect_device();

    }



    //achilles/recorddata
    //tengo que madar foot-> pie derecho, izquierdo
    //sensor1, sensor2, sensor3... 5, con valores entre 0 y 5
    // calories / meters





    private void bluetooth_connect_device() throws IOException
    {
        try
        {
            myBluetooth = BluetoothAdapter.getDefaultAdapter();
            address = myBluetooth.getAddress();
            pairedDevices = myBluetooth.getBondedDevices();
            if (pairedDevices.size()>0)
            {
                for(BluetoothDevice bt : pairedDevices)
                {
                    address=bt.getAddress().toString();name = bt.getName().toString();
                    Toast.makeText(getApplicationContext(),"Connected", Toast.LENGTH_SHORT).show();

                }
            }

        }
        catch(Exception we){}
        myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
        BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
        btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
        btSocket.connect();
        try { t1.setText("BT Name: "+name+"\nBT Address: "+address); }
        catch(Exception e){}
    }

    public void makeRequestWithVolley(String id){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://achillesapp-205313.appspot.com/achilles/login?userId=" + id;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(ContainerActivity.this, "hey", Toast.LENGTH_SHORT).show();
                        Log.d("exito", "la peticion ha sido tramitada con exito");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ContainerActivity.this, "error muy heavy", Toast.LENGTH_SHORT).show();
                Log.d("fucking error", "la peticion ha sido tramitada con mucho error");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }




}



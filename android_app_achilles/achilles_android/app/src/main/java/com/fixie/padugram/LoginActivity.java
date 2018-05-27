package com.fixie.padugram;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fixie.padugram.view.ContainerActivity;
import com.fixie.padugram.view.CreateUserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    String username = "Alberto";
    String password = "1234";
    EditText et_username;
    EditText et_password;
    VideoView videoFondo;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        et_username.setText("sebas@sebas.com");
        et_password.setText("123456");
        playVideo();
    }

    //Aqui va el Registro con Firebase.
    public void goToLogin(View view) {
        if (!et_password.getText().toString().isEmpty() && !et_username.getText().toString().isEmpty()) {
            signInWithUser(et_username.getText().toString(), et_password.getText().toString());
        } else {
            setDialog("Error", "Campos vacios");
        }
    }

    public void successLoginFireb() {
        makeRequestWithVolley("sebas");
    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }

    void setDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    void playVideo() {
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_adidas_recortado);
        videoview.setVideoURI(uri);
        MediaPlayer mp = new MediaPlayer();
        mp.setLooping(true);
        videoview.start();
    }

    void signInWithUser(String _email, String _password) {
        mAuth.signInWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            setDialog("Error", "Usuario y contraseñas incorrectas");
                        } else {
                            successLoginFireb();
                        }
                    }
                });
    }


    void successLoginDatabase(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void makeRequestWithVolley(String id) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://achillesapp-205313.appspot.com/achilles/login?userId=" + id;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(LoginActivity.this, "hey", Toast.LENGTH_SHORT).show();
                        Log.d("exito", "la peticion ha sido tramitada con exito");
                        successLoginDatabase();
                        Log.d("ITS A MOTHERFUCKING", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "error muy heavy", Toast.LENGTH_SHORT).show();
                Log.d("fucking error", "la peticion ha sido tramitada con mucho error");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}


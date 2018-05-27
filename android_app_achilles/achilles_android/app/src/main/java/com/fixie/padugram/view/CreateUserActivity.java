package com.fixie.padugram.view;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fixie.padugram.LoginActivity;
import com.fixie.padugram.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.id.message;

public class CreateUserActivity extends AppCompatActivity {

    String username, name, email, password, confirmPassword;

    EditText et_username;
    EditText et_name;
    EditText et_email;
    EditText et_password;
    EditText et_confirmPassword;

    Button btnActionCreateUser;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        showToolbar(getResources().getString(R.string.toolbar_title_createaccount), true );

        getEditTexts();
        et_username.setText("hola");
        et_name.setText("hola");
        et_email.setText("hola@hola.com");
        et_password.setText("123456");
        et_confirmPassword.setText("123456");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(CreateUserActivity.this, "There is a user",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateUserActivity.this, "There is no user.",
                            Toast.LENGTH_SHORT).show();
                }
                // ...
            }

        };

        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(mAuthListener);

        btnActionCreateUser = (Button) findViewById(R.id.joinUs);

        btnActionCreateUser.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                createUserFir();
            }
        });
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void getEditTexts(){
        et_username = (EditText) findViewById(R.id.user);
        et_email = (EditText) findViewById(R.id.correo);
        et_name = (EditText) findViewById(R.id.name);
        et_password = (EditText) findViewById(R.id.password_createaccount);
        et_confirmPassword = (EditText) findViewById(R.id.confirmPassword);
    }

    public void getTexts(){
        username = et_username.getText().toString();
        email = et_email.getText().toString();
        name = et_name.getText().toString();
        password = et_password.getText().toString();
        confirmPassword = et_confirmPassword.getText().toString();
    }



    public void createUserFir(){
       getTexts();
        mAuth.createUserWithEmailAndPassword("juanito@gmail.com","1234567").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser(); //You Firebase user
                    // user registered, start profile activity
                    Toast.makeText(CreateUserActivity.this,"Account Created",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(CreateUserActivity.this,"Could not create account. Please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    void createUserInDatabase(){
      /*  Usuario userToCreate = new Usuario(username, email, password);

        FirebaseDatabase database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.getReference();

        myRef.setValue(userToCreate);

        finish();*/
    }

    void setDialog(String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(CreateUserActivity.this).create();
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

    private class Usuario {

        String username;
        String email;
        String password;

        Usuario(){
            username = null;
            email = null;
            password = null;
        }

        Usuario(String username, String email, String password){
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }

}



package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences loginCheck= getSharedPreferences("c.sakshilab5", Context.MODE_PRIVATE);

//        String usernameKey = "username";

        if(!loginCheck.getString(usernameKey,"").equals("")){
            String user = loginCheck.getString(usernameKey,"");
            navigateNotes(user);
        }
        else {
            setContentView(R.layout.activity_main);
        }

    }

    public void onButtonClick(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        String user = username.getText().toString();;

        SharedPreferences loginFields = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        loginFields.edit().putString("username", user).apply();

        navigateNotes(user);
    }

    public void navigateNotes(String s){
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}

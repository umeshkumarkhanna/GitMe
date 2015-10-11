package ca.umeshkhanna.gitme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText userNameField = (EditText)findViewById(R.id.userNameField);
        final Button searchUserButton = (Button)findViewById(R.id.searchUserButton);

        searchUserButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameField.getText().toString();
                searchForUser(userName);

            }
        });
    }

    private void searchForUser (String userName){
        GithubApi.getInstance().getUser(userName, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                Bundle userBundle = new Bundle();
                userBundle.putString("name", user.getName());
                userBundle.putString("email", user.getEmail());
                userBundle.putString("avatar_url", user.getAvatar_url());
                userBundle.putString("location", user.getLocation());
                userBundle.putInt("followers", user.getFollowers());
                userBundle.putInt("following", user.getFollowing());
                userBundle.putString("html_url", user.getHtml_url());


                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                intent.putExtras(userBundle);
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Context context = getApplicationContext();
                Toast.makeText(context, "User Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

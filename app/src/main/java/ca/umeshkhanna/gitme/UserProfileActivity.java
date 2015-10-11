package ca.umeshkhanna.gitme;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ImageView userImage = (ImageView)findViewById(R.id.userImage);
        TextView userName = (TextView)findViewById(R.id.userName);
        TextView userLocation = (TextView)findViewById(R.id.userLocation);
        TextView userEmail = (TextView)findViewById(R.id.userEmail);
        TextView userFollowers = (TextView)findViewById(R.id.userFollowers);
        TextView userFollowing = (TextView)findViewById(R.id.userFollowing);

        Bundle userBundle = getIntent().getExtras();
        String name = userBundle.getString("name");
        String email = userBundle.getString("email");
        String avatar_url = userBundle.getString("avatar_url");
        String location = userBundle.getString("location");
        int followers = userBundle.getInt("followers");
        int following = userBundle.getInt("following");

        Picasso.with(this).load(avatar_url).into(userImage);
        userName.setText(name);
        userEmail.setText(email);
        userLocation.setText(location);
        userFollowers.setText(Integer.toString(followers));
        userFollowing.setText(Integer.toString(following));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

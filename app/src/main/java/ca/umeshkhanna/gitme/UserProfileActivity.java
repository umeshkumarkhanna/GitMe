package ca.umeshkhanna.gitme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        Button userProfileRedirect = (Button)findViewById(R.id.redirectButton);

        Bundle userBundle = getIntent().getExtras();
        String name = userBundle.getString("name");
        String email = userBundle.getString("email");
        String avatar_url = userBundle.getString("avatar_url");
        String location = userBundle.getString("location");
        int followers = userBundle.getInt("followers");
        int following = userBundle.getInt("following");
        final String html_url = userBundle.getString("html_url");



        Picasso.with(this).load(avatar_url).into(userImage);
        userName.setText(name);
        userEmail.setText(email);
        userLocation.setText(location);
        userFollowers.setText(Integer.toString(followers));
        userFollowing.setText(Integer.toString(following));

        userProfileRedirect.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(html_url));
                startActivity(intent);
            }
        });




    }


}

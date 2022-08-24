package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Credits extends AppCompatActivity {
    TextView ahmed_mostafa,mohamed_ali,ahmed_montasser,merna_sameh,mazen_magdy,yehia_magdy,ahmed_shabaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        ahmed_mostafa=findViewById(R.id.ahmed_mostafa);

    }
    public void go_to_mostafa_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100005971957794"));
        startActivity(browserIntent);
    }
    public void go_to_mohamed_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100006643026416"));
        startActivity(browserIntent);
    }
    public void go_to_montasser_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ahmed.montasser.7169"));
        startActivity(browserIntent);
    }
    public void go_to_merna_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/merna.fakt"));
        startActivity(browserIntent);
    }
    public void go_to_mazen_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mazinmagdy.zakysaid"));
        startActivity(browserIntent);
    }
    public void go_to_yehia_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/12yehia.magdy"));
        startActivity(browserIntent);
    }
    public void go_to_shabaan_facebook(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ahhmmeed14"));
        startActivity(browserIntent);
    }
}
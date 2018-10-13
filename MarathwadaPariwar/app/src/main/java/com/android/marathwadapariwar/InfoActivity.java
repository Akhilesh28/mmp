package com.android.marathwadapariwar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

public class InfoActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        pdfView = (PDFView) findViewById(R.id.pdfView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String title = bundle.getString("Title");
            getSupportActionBar().setTitle(title);
            if(title.equals("ममीपचे व्हिजन , मिशन आणि व्हॅल्यूज") || title.equals("ममीपची कार्यकारिणी")){
                pdfView.fromAsset(title+".pdf").load();
            }
            else if(title.equals("ममीप अभियंता")) {
                openURI("https://docs.google.com/spreadsheets/d/1rTRODpTquSClGUUgcV3tTDYtJqn4X1nSavUre3-aR50");
            }
            else if(title.equals("ममीप डॉक्टर")) {
                openURI("https://docs.google.com/spreadsheets/d/1vBOonW0XRiQhKhs0xeABNALspLyetTgA0d9XrLOS6q8");
            }
            else if(title.equals("ममीप वकील")) {
                openURI("https://docs.google.com/spreadsheets/d/1Y7UeFRi6lgTLvhSm1dRnYYFsdpvnwhkXejajqWPPzG0");
            }
            else if(title.equals("ममीप पत्रकार")) {
                openURI("https://docs.google.com/spreadsheets/d/15I_S-ONaY3FjZqyV-MgZBnsjiJPDxfuod8oEEMMxQgs");
            }
            else if(title.equals("ममीप शासकीय अधिकारी")) {
                openURI("https://docs.google.com/spreadsheets/d/1U7hRLOz0gHk-WkbdIhRqIV1Gry9sngD9JoW6uzKtOHs");
            }
            else if(title.equals("ममीप आयटी")) {
                openURI("https://docs.google.com/spreadsheets/d/17YLSH0fIT1oZfmyhsm_jJ7lofPS5M8NceR5L0qQ0idI");
            }
            else if(title.equals("ममीप प्राध्यापक")) {
                openURI("https://docs.google.com/spreadsheets/d/1qT_e-qoKSWCiHQCIFoWcwC5IbbJSIG_6yceADiospTg");
            }
            else if(title.equals("ममीप व्यावसायिक")) {
                openURI("https://docs.google.com/spreadsheets/d/1qW6LY4R7NjgRQbtusodFQKnsNUGgTxUfMwL-K5arv4Y");
            }
            else if(title.equals("ममीप छायाचित्रे")) {
                openURI("https://drive.google.com/drive/folders/1r4nB-7EXPaI0XlOOWYKphck8GV2apHy9");
            }
            else if(title.equals("ममीप विडिओ")) {
                openURI("https://drive.google.com/drive/folders/1_lim4m2Vuz48IaxwNz3-XiSuWbdGAqTs");
            }
            else if(title.equals("ममीप मिटींग्स व इतर माहिती")) {
                openURI("https://drive.google.com/drive/folders/1YOOYj8DoEqXiPrqkJVGt3DOoT-IR9apc");
            }
            else if(title.equals("ममीप ऍड")) {
                openURI("https://drive.google.com/drive/folders/1-osHWj8zui9oyObSbLCeJKFWkAiXW-K6");
            }

        }

    }

    public void openURI(String uri){
        Uri location = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
}
